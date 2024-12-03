package br.com.bws.jornaldejundiapeba.application;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> doLogin(@RequestBody LoginRequest loginRequest) {
        String decodedPassword = new String(Base64.getDecoder().decode(loginRequest.getPassword()));

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), decodedPassword)
        );

        if (authentication.isAuthenticated()) {
            String token = "Basic " + Base64.getEncoder().encodeToString(
                    (loginRequest.getUsername() + ":" + decodedPassword).getBytes()
            );
            return ResponseEntity.ok(new LoginResponse(token));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @Getter
    @Setter
    public static class LoginRequest {
        private String username;
        private String password;
    }

    @Getter
    @Setter
    public static class LoginResponse {
        private String message;

        public LoginResponse(String message) {
            this.message = message;
        }
    }

}
