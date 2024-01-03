package ar.com.codoacodo.app.usuarioio.infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ar.com.codoacodo.app.usuario.domain.UsuarioRespository;
import ar.com.codoacodo.dto.reqres.ListResource;

public class RestTempalteUsuarioRepository implements UsuarioRespository {
	
	private String apiEndPoint;
	
	public RestTempalteUsuarioRepository(String apiEndPoint) {
		this.apiEndPoint = apiEndPoint;
	}
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public ListResource getUsuario() {
		
		ResponseEntity<ListResource> response = restTemplate.getForEntity(apiEndPoint, ListResource.class);
		
		return response.getBody();
	}

}
