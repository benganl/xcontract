package za.co.wyzetech.security;

import za.co.wyzetech.security.user.User;

public interface UserService {
    void createUser(String username, String password);

    User findByUsername(String username);
}
