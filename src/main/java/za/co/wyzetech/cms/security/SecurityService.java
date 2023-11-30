package za.co.wyzetech.cms.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.exception.AuthException;
import za.co.wyzetech.cms.user.UserService;

@Slf4j
@Service
public class SecurityService {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final String secret;
    private final long expiration;
    private final SecretKey key;

    public SecurityService(AuthenticationManager authManager, UserService userService, PasswordEncoder passwordEncoder,
	    @Value("${wyzecms.security.secret}") String secret,
	    @Value("${wyzecms.security.token.expiration:604800}") Long expiration) {
	this.secret = secret;
	this.expiration = expiration;
	key = Keys.hmacShaKeyFor(secret.getBytes());
	this.authManager = authManager;
	this.userService = userService;
	this.passwordEncoder = passwordEncoder;
    }

    public String generateToken(String username) {
	Date now = new Date();
	Date expiryDate = new Date(now.getTime() + expiration);
	Map<String, ?> claims = new HashMap<>();
	return Jwts.builder().subject(username).signWith(key).claims(claims).expiration(expiryDate).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
	try {
	    return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject().equals(userDetails
		    .getUsername());
	} catch (Exception e) {
	    return false;
	}
    }

    public boolean validateToken(String token, String username) {
	try {
	    return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject().equals(username);
	} catch (Exception e) {
	    return false;
	}
    }

    public String getUsernameFromToken(String token) {
	return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public Boolean isTokenExpired(String token) {
	Claims payload = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();

	Date expiration = payload.getExpiration();

	return expiration.before(new Date());
    }

    public Authentication authenticate(String username, String password) {
	final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
	try {
	    return authManager.authenticate(authToken);
	} catch (Exception d) {
	    log.warn("Authentication failed for user: {}. Problem: {}", username, d.getMessage());
	    throw new AuthException("Authentication error!!!", d);
	}
    }

    public void create(String username, String password) {
	userService.createUser(username, passwordEncoder.encode(password));
    }
}
