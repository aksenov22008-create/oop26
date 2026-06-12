package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket socket;
    private final Server server;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(),true);
    }



    public void send(String message){
        writer.println(message);
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                server.broadcast(message,this);
            }
            socket.close();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
