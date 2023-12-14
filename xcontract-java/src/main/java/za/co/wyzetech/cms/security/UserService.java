package za.co.wyzetech.cms.security;

import za.co.wyzetech.cms.security.user.User;

public interface UserService {
    void createUser(String username, String password);

    User findByUsername(String username);
}
