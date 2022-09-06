
public class App {
    public static void main(String[] args) {
        Thread server = new EventServer();
        server.start();
    }
}
