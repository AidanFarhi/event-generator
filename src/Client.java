import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread {
    public void run() {
        try {
            Socket socket = new Socket("localhost", 9090);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fromServer;
            while (!(fromServer = in.readLine()).equalsIgnoreCase("done")) {
                System.out.println("From Server: " + fromServer);
            }
            System.out.println("Client disconnecting.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
