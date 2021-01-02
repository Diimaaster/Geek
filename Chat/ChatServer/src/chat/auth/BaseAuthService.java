package chat.auth;

import chat.User;

import java.util.List;

public class BaseAuthService implements AuthService {

    private static final List<User> clients = List.of(
            new User("user1", "1111", "Роман"),
            new User("user2", "2222", "Дмитрий"),
            new User("user3", "3333", "Дед_Мороз"),
            new User("user4", "4444", "Баба_Яга")
    );

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
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
        System.out.println("Сервис аутентификации завершен");

    }
}
