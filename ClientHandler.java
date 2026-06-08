import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Set<ClientHandler> clientHandlers;
    private String clientName;

    public ClientHandler(Socket socket,
                         Set<ClientHandler> clientHandlers) {

        this.socket = socket;
        this.clientHandlers = clientHandlers;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(
                    socket.getOutputStream(), true);

            writer.println("Enter your name:");
            clientName = reader.readLine();

            broadcastMessage("🔵 " + clientName + " joined the chat");

        } catch (IOException e) {
            closeEverything();
        }
    }

    @Override
    public void run() {

        String message;

        try {
            while ((message = reader.readLine()) != null) {

                broadcastMessage(clientName + ": " + message);
            }

        } catch (IOException e) {
            closeEverything();
        }
    }

    private void broadcastMessage(String message) {

        for (ClientHandler client : clientHandlers) {
            client.writer.println(message);
        }
    }

    private void closeEverything() {

        clientHandlers.remove(this);

        broadcastMessage("🔴 " + clientName + " left the chat");

        try {
            if (reader != null)
                reader.close();

            if (writer != null)
                writer.close();

            if (socket != null)
                socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}