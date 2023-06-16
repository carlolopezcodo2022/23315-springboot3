package ar.com.codoacodo.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {

	private Long id;
	private String username;
	private Set<String> roles;
}
