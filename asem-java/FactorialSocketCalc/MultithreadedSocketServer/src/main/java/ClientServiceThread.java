import specialobject.Factorial;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;

class ClientServiceThread extends Thread {
    private Socket clientSocket;
    private int clientID;
    private Factorial factorial;
    private BigInteger result;

    public BigInteger getResult() {
        return result;
    }

    private boolean running = true;

    ClientServiceThread(Socket clientSocket, int id, Factorial factorial) {
        this.clientSocket = clientSocket;
        this.clientID = id;
        this.factorial = factorial;
    }

    @Override
    public void run() {
        System.out.println("Accepted Client : ID - " + clientID + " : Address - "
                + clientSocket.getInetAddress().getHostName());
        try {
            ObjectOutputStream ostream = new ObjectOutputStream(clientSocket.getOutputStream());
            ostream.flush();
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //client validation
            String s = in.readLine();
            if (s!=null && s.equals("<SocketClient>")) {
                out.println("<SocketServer>");
                out.flush();
                Thread.sleep(100);
                ostream.writeObject(factorial);
                ostream.flush();

                String srez = in.readLine();
                result = new BigInteger(srez);
                System.out.println("Client result :" + srez);

            } else {
                System.out.println(clientID + " refused");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("client " + clientID + " Disconnected");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
