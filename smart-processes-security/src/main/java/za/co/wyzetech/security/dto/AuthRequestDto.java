package za.co.wyzetech.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthRequestDto implements Serializable {
    private static final long serialVersionUID = -1L;

    private String username;
    private String password;

    public AuthRequestDto(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
