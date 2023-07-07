package ar.com.codoacodo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.dto.reqres.ListResource;
import ar.com.codoacodo.services.feign.FeignResourceService;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Resource", description = "Resource management APIs")

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceController {

	@Value(value = "${ENDPOINT_REQ_RES}")
	private String apiEndpoint;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<ListResource> findAll() {
		
		/*RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<ListResource> response = restTemplate.getForEntity(apiEndpoint, ListResource.class);
		
		return ResponseEntity.ok(response.getBody());
		*/
		
		FeignResourceService response  = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(FeignResourceService.class))
				  .logLevel(Logger.Level.FULL)
				  .target(FeignResourceService.class, apiEndpoint);
		
		//save en db
		
		return ResponseEntity.ok(response.findAll());
	}
}
