package ar.com.codoacodo.services.feign;

import ar.com.codoacodo.dto.reqres.ListResource;
import feign.RequestLine;

public interface FeignResourceService {
	@RequestLine("GET")
	ListResource findAll();
}
