package ar.com.codoacodo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.domain.User;
import ar.com.codoacodo.dto.UserRequestDTO;
import ar.com.codoacodo.dto.UserResponseDTO;
import ar.com.codoacodo.dto.reqres.ListResource;
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
	
	//GET
	@GetMapping()	
	public ResponseEntity<List<User>> findAll() {
		
		List<User> user = this.userService.buscarTodos();
		
		//http status code=200
		return ResponseEntity.ok(user);
	}
	
	@PostMapping()
	public ResponseEntity<UserResponseDTO> createUser(
			@RequestBody UserRequestDTO request
		)  {
		
		//verifico si existe
		User user = this.userService.buscarUserPorUsername(request.getUsername());
		if(user != null) {
			UserResponseDTO response = UserResponseDTO.builder()
				.username(user.getUsername())
				.build();
			
			return ResponseEntity.ok(response);
		}
		
		//sino lo crea
		//validacion!!!
		User newUser = User.builder()
				.username(request.getUsername())
				.password(request.getPassword())
				.build();
				
		this.userService.crearUser(newUser);
		
		UserResponseDTO response = UserResponseDTO.builder()
			.username(newUser.getUsername())
			.build();
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> actualizar(
			@PathVariable("id") Long id			
		) {
		
		this.userService.eliminarUser(id);
		
		return ResponseEntity.ok().build();
	}
	
	/*Idempotentes
	 * user/1
	{
		alias: 'nuevoalias'
		id: 2
	}
	 */
}
