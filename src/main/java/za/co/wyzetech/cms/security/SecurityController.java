package za.co.wyzetech.cms.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.exception.AuthException;
import za.co.wyzetech.cms.integration.dto.AuthRequestDto;
import za.co.wyzetech.cms.integration.dto.AuthResponseDto;

@Slf4j
@RestController
@RequestMapping("/auth")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
	this.securityService = securityService;
    }

    @GetMapping("/ping")
    public String firstPage() {
	return "Hello World!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequestDto loginRequest) throws Exception {
	try {
	    Authentication auth = securityService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
	    String token = securityService.generateToken(auth.getName());
	    AuthResponseDto loginRes = new AuthResponseDto(token, 200, "success");
	    return ResponseEntity.ok(loginRes);
	} catch (AuthException e) {
	    AuthResponseDto errorResponse = new AuthResponseDto(null, HttpStatus.BAD_REQUEST.value(),
		    "Invalid username or password");
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	} catch (Exception e) {
	    AuthResponseDto errorResponse = new AuthResponseDto(null, HttpStatus.BAD_REQUEST.value(), e.getMessage());
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody AuthRequestDto loginRequest) throws Exception {
	try {
	    securityService.create(loginRequest.getUsername(), loginRequest.getPassword());
	    return ResponseEntity.ok("success");
	} catch (Exception e) {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
    }
}