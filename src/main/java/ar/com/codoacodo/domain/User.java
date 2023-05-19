package ar.com.codoacodo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*representar la tabla USUARIOS*/
@Entity
@Table(name = "user")
public class User {
	@Id
	private Long id;
	
	@Column(name="username",length = 50,unique = true)
	private String username;
	
	@Column(name="password",length = 50)
	private String password;
	
}
