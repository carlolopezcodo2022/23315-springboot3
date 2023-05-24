package ar.com.codoacodo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.domain.User;
import ar.com.codoacodo.services.UserService;
import lombok.RequiredArgsConstructor;

//http://localhost:8081/user

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	//necesito el service
	private final UserService userService;
	
	//GET
	@GetMapping("/{id}")	
	public ResponseEntity<User> m1(
			@PathVariable("id") Long id
			) {
		
		User user = this.userService.buscarUser(id);
		
		//http status code=200
		return ResponseEntity.ok(user);
	}
}
