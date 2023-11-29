package za.co.wyzetech.cms.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest  implements Serializable {
    private static final long serialVersionUID = -1L;

    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
