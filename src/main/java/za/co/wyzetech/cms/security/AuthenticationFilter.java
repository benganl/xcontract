package za.co.wyzetech.cms.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.user.UserService;

/*
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final SecurityService securityService;

    public AuthenticationFilter(UserService userService, SecurityService securityService) {
	this.userService = userService;
	this.securityService = securityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	    throws ServletException, IOException {

	final String requestTokenHeader = request.getHeader("Authorization");

	String username = null;
	String token = null;

	if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
	    token = requestTokenHeader.substring(7);
	    try {
		username = securityService.getUsernameFromToken(token);
	    } catch (IllegalArgumentException e) {
		log.info("Unable to get JWT Token");
	    } catch (ExpiredJwtException e) {
		log.info("JWT Token has expired");
	    }
	} else {
	    logger.warn("JWT Token does not begin with Bearer String");
	}

	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	    UserDetails userDetails = this.userService.loadUserByUsername(username);
	    if (securityService.validateToken(token, userDetails)) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
			userDetails, null, userDetails.getAuthorities());

		usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	    }
	}

	chain.doFilter(request, response);
    }
}
*/