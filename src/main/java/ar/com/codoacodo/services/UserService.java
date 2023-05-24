package ar.com.codoacodo.services;

import ar.com.codoacodo.domain.User;

public interface UserService {

	public void crearUser(User user);
	public User buscarUser(Long id);
}
