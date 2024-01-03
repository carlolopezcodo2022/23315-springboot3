package ar.com.codoacodo.app.usuarioio.infrastructure;

import org.springframework.http.ResponseEntity;

import ar.com.codoacodo.app.usuario.domain.UsuarioRespository;
import ar.com.codoacodo.dto.reqres.ListResource;
import ar.com.codoacodo.services.feign.FeignResourceService;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeignUsuarioRepository implements UsuarioRespository {

	private String apiEndpoint;
	
	public FeignUsuarioRepository(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
	}
	
	@Override
	public ListResource getUsuario() {
		FeignResourceService response  = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(FeignResourceService.class))
				  .logLevel(Logger.Level.FULL)
				  .target(FeignResourceService.class, apiEndpoint);
		
		//save en db
		
		return response.findAll();
	}

}
