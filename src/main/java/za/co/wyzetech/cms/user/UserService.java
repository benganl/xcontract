package za.co.wyzetech.cms.user;

public interface UserService {
    void createUser(String username, String password);

    User findByUsername(String username);
}
