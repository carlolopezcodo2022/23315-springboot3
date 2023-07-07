package ar.com.codoacodo.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.domain.Role;
import ar.com.codoacodo.domain.User;
import ar.com.codoacodo.dto.UserDTO;
import ar.com.codoacodo.dto.UserRequestDTO;
import ar.com.codoacodo.dto.UserRequestPutDTO;
import ar.com.codoacodo.dto.UserResponseDTO;
import ar.com.codoacodo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

//http://localhost:8081/user

@Tag(name = "User", description = "User management APIs")
//@CrossOrigin(origins = "http://localhost:5500")

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	// necesito el service
	private final UserService userService;

	// GET
	@Operation(
			summary = "Retrieve a User by Id", 
			description = "Get a User object by specifying its id. The response is Tutorial object with id, title, description and published status.", 
			tags = {"users", "get" })
	@ApiResponses({
			@ApiResponse(
					responseCode = "200", 
					content = { 
							@Content(schema = @Schema(implementation = UserDTO.class), mediaType = "application/json") 
					}
			),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> m1(@PathVariable("id") Long id) {

		User user = this.userService.buscarUser(id);

		UserDTO dto = UserDTO.builder().id(user.getId()).username(user.getUsername())
				.roles(user.getRoles().stream().map(x -> x.getRol()).collect(Collectors.toSet())).build();

		// http status code=200
		return ResponseEntity.ok(dto);
	}

	// GET
	@GetMapping()
	public ResponseEntity<List<User>> findAll() {

		List<User> user = this.userService.buscarTodos();

		// http status code=200
		return ResponseEntity.ok(user);
	}

	@Operation(summary = "Create a new User", tags = { "users", "post" })
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = UserResponseDTO.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping()
	@PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {

		// verifico si existe
		User user = this.userService.buscarUserPorUsername(request.getUsername());
		if (user != null) {
			UserResponseDTO response = UserResponseDTO.builder().username(user.getUsername()).build();

			return ResponseEntity.ok(response);
		}

		// sino lo crea
		// validacion!!!
		// ["1","2","3"]
		Set<Role> rolesDelUsuario = request.getRoles().stream().map(r -> Role.builder().id(Long.parseLong(r)).build())
				.collect(Collectors.toSet());

		User newUser = User.builder().username(request.getUsername())
				.password(new BCryptPasswordEncoder().encode(request.getPassword())).roles(rolesDelUsuario).build();

		this.userService.crearUser(newUser);

		UserResponseDTO response = UserResponseDTO.builder().username(newUser.getUsername()).build();

		return ResponseEntity.ok(response);
	}

	@Operation(summary = "Delete a Users by Id", 
			tags = { "users", "delete" })
	@ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> actualizar(@PathVariable("id") Long id) {

		this.userService.eliminarUser(id);

		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Update a User by Id", tags = { "users", "put" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = UserRequestPutDTO.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }) })
	/*
	 * Idempotentes user/1 { alias: 'nuevoalias' id: 2 }
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UserRequestPutDTO> actualizarPorPut(
			@PathVariable(name = "id", required = true) Long id,
			@Validated @RequestBody UserRequestPutDTO request) 
	{

		User user = this.userService.buscarUser(id);
		if (!user.getId().equals(request.getId())) {
			return ResponseEntity.badRequest().build();
		}

		user.setPassword(request.getPassword());
		// otros atributos en base al request

		this.userService.actualizar(user);

		return ResponseEntity.ok().build();
	}

	// path!
}
