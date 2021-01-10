package chat.handler;

import chat.MyServer;
import chat.auth.AuthService;
import clientserver.Command;
import clientserver.CommandType;
import clientserver.commands.AuthCommandData;
import clientserver.commands.PrivateMessageCommandData;
import clientserver.commands.PublicMessageCommandData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {

    private final MyServer myServer;
    private final Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private String username;

    public ClientHandler(MyServer myServer, Socket clientSocket) {
        this.myServer = myServer;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {
        in = new ObjectInputStream(clientSocket.getInputStream());
        out = new ObjectOutputStream(clientSocket.getOutputStream());

//        new Timer().schedule();
        new Thread(() -> {
            try {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Авторизация не пройдена за 120 секунд, разрываем соединение");
                            sendMessage(Command.authErrorCommand("Ошибка авторизации. Авторизация не пройдена за 120 секунд"));
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, 120000);
                authentication();
                readMessage();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }).start();

    }

    private void authentication() throws IOException {

        while (true) {

            Command command = readCommand();
            if (command == null) {
                continue;
            }
            if (command.getType() == CommandType.AUTH) {

                boolean isSuccessAuth = processAuthCommand(command);
                if (isSuccessAuth) {
                    break;
                }

            } else {
                sendMessage(Command.authErrorCommand("Ошибка авторизации"));

            }
        }

    }

    private boolean processAuthCommand(Command command) throws IOException {
        AuthCommandData cmdData = (AuthCommandData) command.getData();
        String login = cmdData.getLogin();
        String password = cmdData.getPassword();

        AuthService authService = myServer.getAuthService();
        this.username = authService.getUsernameByLoginAndPassword(login, password);
        if (username != null) {
            if (myServer.isUsernameBusy(username)) {
                sendMessage(Command.authErrorCommand("Логин уже используется"));
                return false;
            }

            sendMessage(Command.authOkCommand(username));
            String message = String.format(">>> %s присоединился к чату", username);
            myServer.broadcastMessage(this, Command.messageInfoCommand(message, null));
            myServer.subscribe(this);
            return true;
        } else {
            sendMessage(Command.authErrorCommand("Логин или пароль не соответствуют действительности"));
            return false;
        }
    }

    private Command readCommand() throws IOException {
        try {
            return (Command) in.readObject();
        } catch (ClassNotFoundException e) {
            String errorMessage = "Получен неизвестный объект";
            System.err.println(errorMessage);
            e.printStackTrace();
            return null;
        }
    }

    private void readMessage() throws IOException {
        while (true) {
            Command command = readCommand();
            if (command == null) {
                continue;
            }

            switch (command.getType()) {
                case END:
                    myServer.unSubscribe(this);
                    return;
                case PUBLIC_MESSAGE: {
                    PublicMessageCommandData data = (PublicMessageCommandData) command.getData();
                    String message = data.getMessage();
                    String sender = data.getSender();
                    myServer.broadcastMessage(this, Command.messageInfoCommand(message, sender));
                    break;
                }
                case PRIVATE_MESSAGE:
                    PrivateMessageCommandData data = (PrivateMessageCommandData) command.getData();
                    String recipient = data.getReceiver();
                    String message = data.getMessage();
                    myServer.sendPrivateMessage(recipient, Command.messageInfoCommand(message, username));
                    break;
                default:
                    String errorMessage = "Неизвестный тип команды" + command.getType();
                    System.err.println(errorMessage);
                    sendMessage(Command.errorCommand(errorMessage));
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(Command command) throws IOException {
        out.writeObject(command);
    }
}
