package ar.com.codoacodo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> fallaValidacion(MethodArgumentNotValidException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
