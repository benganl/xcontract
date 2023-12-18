package za.co.wyzetech.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import za.co.wyzetech.security.SecurityService;
import za.co.wyzetech.security.UserService;
import za.co.wyzetech.security.dto.AuthRequestDto;
import za.co.wyzetech.security.dto.AuthResponseDto;
import za.co.wyzetech.security.exception.AuthException;


@Slf4j
@RestController
@RequestMapping("/auth")
public class SecurityController {

    private final SecurityService securityService;
    private final UserService userService;

    public SecurityController(SecurityService securityService, UserService userService) {
        this.securityService = securityService;
        this.userService = userService;
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
            userService.createUser(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
