import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String urlString = "http://ciprianthomson.hopto.org";
        InetAddress address = null;
        try {
            address = InetAddress.getByName(new URL(urlString).getHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String server = address.getHostAddress();
        int port = 8888;

        if(args.length == 2){
            server = args[0];
            port = Integer.parseInt(args[1]);
        }

        SpecialClient specialClient = new SpecialClient(server,port);
        System.out.println("client started");
    }
}
