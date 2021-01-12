package chat.auth;

import chat.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class BaseAuthService implements AuthService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(BaseAuthService.class);

    private static final List<User> clients = List.of(
            new User("user1", "1111", "Борис_Николаевич"),
            new User("user2", "2222", "Мартин_Некотов"),
            new User("user3", "3333", "Гендальф_Серый")
    );

    @Override
    public void start() {
        LOGGER.info("Сервис аутентификации запущен");
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        for (User client : clients) {
            if(client.getLogin().equals(login) && client.getPassword().equals(password)) {
                return client.getUsername();
            }
        }
        return null;
    }

    @Override
    public void close() {
        LOGGER.info("Сервис аутентификации завершен");
    }
}
