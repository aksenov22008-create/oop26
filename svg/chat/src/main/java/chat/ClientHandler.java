package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private String login;
    private final Socket socket;
    private final Server server;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(),true);
        this.login = reader.readLine();
    }
    public String getLogin(){
        return login;
    }


    public void send(String message){
        writer.println(message);
    }

    @Override
    public void run() {
        String message;
        try {
            this.login = reader.readLine();
            System.out.println("Login: "+this.login);
            while ((message = reader.readLine()) != null) {
                if (message.startsWith("/")) {
                    String[] parts = message.split(" ", 3);
                    String command = parts[0];
                    switch (command) {
                        case "/online" -> {
                            server.online(this);
                        }
                        //4b
                        case "/w" -> {
                            if (parts.length < 3) {
                                send("Usage: /w recipient message");
                                continue;
                            }
                            String recipient = parts[1];
                            String privateMessage = parts[2];
                            server.whisper(recipient, privateMessage, this);
                        }
                    }
                    continue;
                }
                server.broadcast(login+" :"+message,this);
            }
            socket.close();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

}
