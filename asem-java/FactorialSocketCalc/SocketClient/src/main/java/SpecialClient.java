import specialobject.Factorial;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;

public class SpecialClient {
    private String server;
    private int port;

    private boolean running = true;

    public SpecialClient(String server, int port) {
        this.server = server;
        this.port = port;


        while (true) {
            try {
                System.out.print("Try to connect to " + server + ":" + port + "...");
                init();
            } catch (IOException e) {
                System.out.println(" failed");
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private void init() throws IOException {
        Socket clientSocket = new Socket(server, port);
        System.out.println("conected");

        ObjectInputStream oistream = new ObjectInputStream(clientSocket.getInputStream());
        PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("<SocketClient>");
        out.flush();

        Factorial factorial = null;

        //server validation
        String s = in.readLine();
        BigInteger result;
        if (s.equals("<SocketServer>")){
            try {
                factorial = (Factorial) oistream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Not a valid object");
                e.printStackTrace();
            }
            System.out.println("calulating...");
            result = factorial.getResult();
            System.out.println("result sent.");
            out.println(result);
            out.flush();

        }else{
            System.out.println("Not a valid server");
        }
    }
}