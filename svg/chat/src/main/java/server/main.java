package src.main.java.server;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(3001);
        server.listen();
    }
}
