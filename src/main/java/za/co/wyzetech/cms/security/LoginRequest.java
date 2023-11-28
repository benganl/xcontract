package za.co.wyzetech.cms.security;

import lombok.Data;

@Data
class LoginRequest {
    private String username;
    private String password;
}
