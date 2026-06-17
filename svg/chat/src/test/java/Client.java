import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 3001);

        BufferedReader keyboard =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedReader serverReader =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter writer =
                new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Login: ");
        String login = keyboard.readLine();

        writer.println(login);

        Thread receiver = new Thread(() -> {
            try {
                String message;
                while ((message = serverReader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Disconnected from server.");
            }
        });

        receiver.setDaemon(true);
        receiver.start();

        String message;
        while ((message = keyboard.readLine()) != null) {
            writer.println(message);
        }

        socket.close();
    }
}