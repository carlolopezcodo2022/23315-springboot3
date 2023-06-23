package ar.com.codoacodo.security;

import org.springframework.http.ResponseEntity;
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

	@PostMapping
	public ResponseEntity<String> authenticate(
			@RequestBody AuthenticationRequest request, HttpServletResponse response){
		
		//authenticationmanager
		
		//userdetails
		
		//jwtutils
		
		//response jwt
		
		return null;
	}
}
