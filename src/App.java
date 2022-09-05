
public class App {
    public static void main(String[] args) {
        Thread client = new Client();
        Thread server = new EventServer();
        server.start();
        client.start();
    }
}
