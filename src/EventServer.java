import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class EventServer extends Thread {

    private final Random rand = new Random();
    private final String[] locations = {"NY", "NJ", "OR", "DE", "PA", "CA", "TX"};

    private String generateEvent() {
        IOTEvent event = new IOTEvent(
                rand.nextInt(1, 100_000),
                locations[rand.nextInt(locations.length)],
                rand.nextDouble() * 100,
                rand.nextInt(1, 100)
        );
        return event + "\n";
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                for (int i = 0; i < 10; i++) { // send 10 events to client
                    String event = generateEvent();
                    out.write(event);
                    out.flush();
                    System.out.println(event);
                    Thread.sleep(250);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
