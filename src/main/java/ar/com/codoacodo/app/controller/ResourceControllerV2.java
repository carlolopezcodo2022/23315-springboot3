package ar.com.codoacodo.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.app.usuario.application.GetUsuario;
import ar.com.codoacodo.app.usuario.domain.UsuarioRespository;
import ar.com.codoacodo.app.usuarioio.infrastructure.FeignUsuarioRepository;
import ar.com.codoacodo.app.usuarioio.infrastructure.RequestParams;
import ar.com.codoacodo.app.usuarioio.infrastructure.RestTempalteUsuarioRepository;
import ar.com.codoacodo.app.usuarioio.infrastructure.UsuarioDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/resource-v2")
@RequiredArgsConstructor
public class ResourceControllerV2 {

	@Value(value = "${ENDPOINT_REQ_RES}")
	private String apiEndpoint;
	
	//feature flag
	@Value(value = "${REQ_RES_IMPL}")
	private String reqResImpl;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<UsuarioDTO> findAll() {
		
		UsuarioRespository respository;
		if("feign".equals(reqResImpl)) {
			respository = new FeignUsuarioRepository(apiEndpoint);
		}else {
			respository = new RestTempalteUsuarioRepository(apiEndpoint);
		}
		//clean 
		GetUsuario casoDeUso = new GetUsuario(respository);
		
		UsuarioDTO usuarioDto = casoDeUso.exec(new RequestParams());
		
		return ResponseEntity.ok(usuarioDto);
	}
}
