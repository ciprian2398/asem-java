import specialobject.Factorial;

import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class SpecialServer {

    public static void main(String[] args) {


        Queue<ClientServiceThread> clientList = new ArrayBlockingQueue<>(100);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Factorial = ");
        BigInteger myInteger = scanner.nextBigInteger();
        System.out.print("Num of clients> ");
        int n = Integer.parseInt(scanner.next());

        List<Factorial> factorials = new ArrayList<Factorial>();

        BigInteger unit = myInteger.divide(BigInteger.valueOf(n));
        factorials.add(new Factorial(BigInteger.valueOf(1),unit));

        for (int i = 1; i < n; i++) {
            BigInteger i1 = factorials.get(i - 1).getTo().add(BigInteger.valueOf(1));
            BigInteger i2 ;

            if (i == n-1) {
                i2 = myInteger;
            }else {
                i2 = unit.multiply(BigInteger.valueOf(i + 1));
            }

            factorials.add(new Factorial(i1, i2));
        }

        for (Factorial factorial: factorials) {
            System.out.println(factorial.getFrom() +"  "+ factorial.getTo());
        }

        ServerSocket m_ServerSocket = null;
        try {
            m_ServerSocket = new ServerSocket(8888);
        } catch (IOException e) {
            System.out.println("Port is busy.");
        }

        int id = 0;

        while (clientList.size() != n) {
            Socket clientSocket = null;
            try {
                clientSocket = m_ServerSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("+ "+clientSocket.getInetAddress().getHostAddress());

            ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++ , factorials.get(id-1));
            clientList.add(cliThread);
        }
        try {
            m_ServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ClientServiceThread cliThread: clientList){
            cliThread.start();
        }

        for (ClientServiceThread cliThread: clientList){
            try {
                cliThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        BigInteger finalRez = BigInteger.valueOf(1);
        for (ClientServiceThread cliThread: clientList){
            finalRez = finalRez.multiply(cliThread.getResult());
        }

        System.out.println("Final result : \n"+ finalRez);

    }
}