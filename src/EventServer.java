import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class EventServer extends Thread {

    private final Random rand = new Random();
    private final String[] locations = {"NY", "NJ", "OR", "DE", "PA", "CA", "TX"};

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                for (int i = 0; i < 10; i++) {
                    IOTEvent event = new IOTEvent(
                            rand.nextInt(1, 100_000),
                            locations[rand.nextInt(locations.length)],
                            rand.nextDouble() * 100,
                            rand.nextInt(1, 100)
                    );
                    out.println(event);
                    Thread.sleep(250);
                }
                out.println("done");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
