package za.co.wyzetech.cms.integration.restful;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.wyzetech.cms.integration.dto.LoginRequest;
import za.co.wyzetech.cms.integration.dto.LoginResponse;
import za.co.wyzetech.cms.security.SecurityService;
import za.co.wyzetech.cms.user.UserService;

@RestController("web")
public class SecurityController {

    private final AuthenticationManager authenticationManager;
    private final SecurityService securityService;
    private final UserService userDetailsService;

    public SecurityController(AuthenticationManager authenticationManager, SecurityService securityService,
	    UserService userDetailsService) {
	this.authenticationManager = authenticationManager;
	this.securityService = securityService;
	this.userDetailsService = userDetailsService;
    }

    @GetMapping({ "/hello" })
    public String firstPage() {
	return "Hello World!";
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
	try {
	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
		    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	    String username = authentication.getName();
	    String token = securityService.generateToken(username);
	    LoginResponse loginRes = new LoginResponse(token, 200, "success");
	    return ResponseEntity.ok(loginRes);
	} catch (BadCredentialsException e) {
	    LoginResponse errorResponse = new LoginResponse(null, HttpStatus.BAD_REQUEST.value(),
		    "Invalid username or password");
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	} catch (Exception e) {
	    LoginResponse errorResponse = new LoginResponse(null, HttpStatus.BAD_REQUEST.value(), e.getMessage());
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
    }
}
