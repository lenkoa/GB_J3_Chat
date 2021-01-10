package lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {

    private static final int SERVER_PORT = 8189;
    private static final String SERVER_HOST = "localhost";

    private final int port;
    private final String host;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

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

    public void waitMessage(ViewController viewController) {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    viewController.appendMessage("Я: " + message);
                }

            }
            catch (IOException e) {
                e.printStackTrace();
                EchoClient.showErrorMessage("Ошибка подключения", "", e.getMessage());
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
