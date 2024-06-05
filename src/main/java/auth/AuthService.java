package auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.CsvUtils;

public class AuthService {
    private static AuthService instance;
    private Map<String, User> users;

    private AuthService() {
        users = new HashMap<>();
        loadUsers();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User register(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    private void loadUsers() {
        List<Map<String, String>> userList = CsvUtils.readCsv("src/main/resources/users.csv");
        for (Map<String, String> userData : userList) {
            String username = userData.get("username");
            String password = userData.get("password");
            users.put(username, new User(username, password));
        }
    }
}