package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = -1L;

    private String username;
    private String password;

    public LoginRequest(String username, String password) {
	this.setUsername(username);
	this.setPassword(password);
    }
}
