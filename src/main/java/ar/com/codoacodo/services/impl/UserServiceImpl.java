package ar.com.codoacodo.services.impl;

import org.springframework.stereotype.Service;

import ar.com.codoacodo.domain.User;
import ar.com.codoacodo.repository.UserRepository;
import ar.com.codoacodo.services.UserService;
import lombok.RequiredArgsConstructor;

//lombok
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	//D.I
	private final UserRepository repository;
	
	/*
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}*/
	
	@Override
	public void crearUser(User user) {
		//aca va la logica de insert!
		this.repository.save(user);
		//insert into tabla (c1,c2..cn) values(v1,v2....vn)
	}

	@Override
	public User buscarUser(Long id) {
		//select * from tabla where id = id
		
		//mapper! mapstruct!
		return this.repository.findById(id).get();
	}

}
