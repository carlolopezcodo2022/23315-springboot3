package ar.com.codoacodo.security;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;

	private final JpaUserDetailsService jpaUserDetailsService;

    private final JwtUtils jwtUtils;
    
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request,
			HttpServletResponse response) {

		// authenticationmanager

		// userdetails

		// jwtutilsz

		// response jwt

		try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                    		request.getUsername(), 
                    		request.getPassword(),
                            new ArrayList<>())
                    		);
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(request.getUsername());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);
                
                return ResponseEntity.ok(jwt);
            }
            return ResponseEntity.status(400).body("Error authenticating");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body("" + e.getMessage());
        }
	}
}
