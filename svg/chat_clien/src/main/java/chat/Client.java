package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public Client(String addres,int port) throws IOException {
        this.socket = new Socket(addres,port);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(),true);
    }
    public void send(String message){
        writer.println(message);
    }
}
