package dzamsheed.uz.auth_service.module.auth;

import dzamsheed.uz.auth_service.module.users.User;
import dzamsheed.uz.auth_service.module.users.UserRepository;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final BlacklistedTokenRepository blacklistedTokenRepository;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (Exception e) {
            return ResponseEntity.status(409).body("Incorrect username or password");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public HttpEntity<?> createUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/logout")
    public HttpEntity<?> logout(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        try {
            if (jwtUtil.validateToken(token)) {
                Date expiryDate = jwtUtil.extractExpiration(token);
                BlacklistedToken blacklistedToken = new BlacklistedToken();
                blacklistedToken.setToken(token);
                blacklistedToken.setExpiryDate(expiryDate);
                blacklistedTokenRepository.save(blacklistedToken);
            }
        }catch (Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }

        return ResponseEntity.ok("Logged out successfully");
    }

    @GetMapping("/validate-token")
    @PermitAll
    public ResponseEntity<Map<String, Object>> parseToken(@RequestHeader("Authorization") String token) {
        Map<String, Object> retVal = new HashMap<>();
        if (token != null && token.startsWith("Bearer ")){
            String jwt = token.substring(7);
            try {
                boolean success = jwtUtil.validateToken(jwt);
                retVal.put("success", success);
                retVal.put("message", "Success");
                retVal.put("data", jwtUtil.parseToken(jwt));
            } catch (Exception e) {
                retVal.put("success", false);
                retVal.put("message", e.getMessage());
                retVal.put("data", null);
            }
        }
        return ResponseEntity.ok(retVal);
    }
}

