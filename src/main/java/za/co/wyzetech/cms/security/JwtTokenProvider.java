package za.co.wyzetech.cms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    private final String secret;
    private final long expiration;
    private final SecretKey key;

    public JwtTokenProvider(@Value("${wyzecms.security.secret}") String secret,
                            @Value("${wyzecms.security.token.expiration:604800}") Long expiration) {
        this.secret = secret;
        this.expiration = expiration;
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        Map<String, ?> claims = new HashMap<>();

        return Jwts.builder()
                .subject(username)
                .signWith(key)
                .claims(claims)
                .expiration(expiryDate)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            return Jwts.parser()
                    .verifyWith(key).build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject().equals(userDetails.getUsername());
        } catch (Exception e) {
            // Handle exceptions (e.g., expired token, invalid signature)
            return false;
        }
    }

    public boolean validateToken(String token, String username) {
        try {
            return Jwts.parser()
                    .verifyWith(key).build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject().equals(username);
        } catch (Exception e) {
            // Handle exceptions (e.g., expired token, invalid signature)
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith(key).build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        Claims payload = Jwts.parser()
                .verifyWith(key).build()
                .parseSignedClaims(token)
                .getPayload();

        Date expiration = payload.getExpiration();

        return expiration.before(new Date());
    }
}