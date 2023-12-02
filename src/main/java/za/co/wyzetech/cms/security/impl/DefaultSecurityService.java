package za.co.wyzetech.cms.security.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.common.JwtUtils;
import za.co.wyzetech.cms.exception.AuthException;
import za.co.wyzetech.cms.security.SecurityService;
import za.co.wyzetech.cms.user.UserService;

@Slf4j
@Service
class DefaultSecurityService implements SecurityService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtil;
    private final Long expiration;

    public DefaultSecurityService(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authManager,
	    JwtUtils jwtUtil, @Value("${wyzecms.security.token.expiration:604800}") Long expiration) {
	this.userService = userService;
	this.passwordEncoder = passwordEncoder;
	this.authManager = authManager;
	this.jwtUtil = jwtUtil;
	this.expiration = expiration;
    }

    @Override
    public String generateToken(String username) {
	return jwtUtil.generateToken(username, expiration);
    }

    @Override
    public Boolean validateToken(String token, String username) {
	try {
	    return jwtUtil.validateToken(token, username);
	} catch (Exception e) {
	    return false;
	}
    }

    @Override
    public String getUsernameFromToken(String token) {
	return jwtUtil.getUsernameFromToken(token);
    }

    @Override
    public Boolean isTokenExpired(String token) {
	return jwtUtil.isTokenExpired(token);
    }

    @Override
    public Authentication authenticate(String username, String password) {
	final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
	try {
	    return authManager.authenticate(authToken);
	} catch (Exception d) {
	    log.warn("Authentication failed for user: {}. Problem: {}", username, d.getMessage());
	    throw new AuthException("Authentication error!!!", d);
	}
    }

    @Override
    public void create(String username, String password) {
	userService.createUser(username, passwordEncoder.encode(password));
    }
}
