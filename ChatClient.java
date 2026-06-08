import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ChatClient(Socket socket) {

        try {
            this.socket = socket;

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(
                    socket.getOutputStream(), true);

        } catch (IOException e) {
            closeEverything();
        }
    }

    public void sendMessage() {

        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        writer.println(username);

        while (socket.isConnected()) {

            String message = scanner.nextLine();
            writer.println(message);
        }
    }

    public void listenForMessage() {

        new Thread(() -> {

            String msg;

            try {
                while ((msg = reader.readLine()) != null) {
                    System.out.println(msg);
                }

            } catch (IOException e) {
                closeEverything();
            }

        }).start();
    }

    private void closeEverything() {

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

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            ChatClient client = new ChatClient(socket);

            client.listenForMessage();
            client.sendMessage();

        } catch (IOException e) {
        
                   e.printStackTrace();
            }
        }
    }
