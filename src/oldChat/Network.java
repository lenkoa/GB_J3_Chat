/*
package oldChat;

import client.NetworkClient;
import client.controllers.ChatController;
import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    private static final String AUTH_CMD_PREFIX = "/auth";
    private static final String AUTHOK_CMD_PREFIX = "/authok";
    private static final String AUTHERR_CMD_PREFIX = "/autherr";
    private static final String PRIVATE_MSG_PREFIX = "/w";
    private static final String CLIENT_MSG_PREFIX = "/clientMsg";
    private static final String SERVER_MSG_PREFIX = "/serverMsg";
    private static final String END_CMD = "/end";

    private static final int SERVER_PORT = 8189;
    private static final String SERVER_HOST = "localhost";

    private final int port;

    private final String host;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private String username;
    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public Network(String serverHost, int serverPort) {
        this.host = serverHost;
        this.port = serverPort;
    }

    public boolean connect() {
        try {
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            System.out.println("Соединение не было установлено");
            e.printStackTrace();
            return false;
        }


    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {


        }
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void waitMessage(ChatController chatController) {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();

                    if(message.startsWith(CLIENT_MSG_PREFIX)) {
                        String[] parts = message.split("\\s+", 3);
                        String sender = parts[1];
                        String msgBody = parts[2];

                        Platform.runLater(() -> chatController.appendMessage(String.format("%s: %s", sender, msgBody)));
                    }
                    else if(message.startsWith(SERVER_MSG_PREFIX)) {
                        String[] parts = message.split("\\s+", 2);
                        Platform.runLater(() -> chatController.appendMessage(parts[1]));
                    }
                    else {
                        Platform.runLater(() -> NetworkClient.showErrorMessage("Неизвестная команда", message, ""));
                    }
                    }



            }
            catch (IOException e) {
                e.printStackTrace();
                NetworkClient.showErrorMessage("Ошибка подключения", "", e.getMessage());
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public String sendAuthCommand(String login, String password) {
        try {

            sendMessage(String.format("%s %s %s", AUTH_CMD_PREFIX, login, password));

            String response = in.readUTF();
            if (response.startsWith(AUTHOK_CMD_PREFIX)) {
                this.username = response.split("\\s+", 2)[1];
                return null;
            }
            return response.split("\\s+", 2)[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }
}
*/
