package chat.auth;

public interface AuthService {

    void start();

    String getUsernameByLoginAndPassword(String login, String password);

    void close();
}
