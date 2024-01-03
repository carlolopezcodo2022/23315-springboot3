package ar.com.codoacodo.app.usuario.application;

import ar.com.codoacodo.app.usuario.domain.UsuarioRespository;
import ar.com.codoacodo.app.usuarioio.infrastructure.RequestParams;
import ar.com.codoacodo.app.usuarioio.infrastructure.UsuarioDTO;
import ar.com.codoacodo.dto.reqres.ListResource;

public class GetUsuario {

	private UsuarioRespository repository;
	
	public GetUsuario(UsuarioRespository repository) {
		this.repository = repository;
	}
	
	public UsuarioDTO exec(RequestParams params) {
		ListResource response = this.repository.getUsuario();
		
		//puedo convertir los datos antes de que salgan 
		//covnerter/mapper/
		return new UsuarioDTO(new Long(response.getData().get(0).getId()),response.getData().get(0).getName());
	}
}
