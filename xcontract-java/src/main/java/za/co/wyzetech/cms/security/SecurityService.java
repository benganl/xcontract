package za.co.wyzetech.cms.security;

import org.springframework.security.core.Authentication;

public interface SecurityService {

    String generateToken(String username);

    Boolean validateToken(String token, String username);

    String getUsernameFromToken(String token);

    Boolean isTokenExpired(String token);

    Authentication authenticate(String username, String password);
}
