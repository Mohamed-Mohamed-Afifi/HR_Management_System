package com.afify.hr_system.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handelRecordNotFound(RecordNotFoundException ex){
		ErrorResponse error=new ErrorResponse(ex.getMessage(),404);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DuplicatedException.class)
	public ResponseEntity<?> handleDuplicated(DuplicatedException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getLocalizedMessage(),400));
	}
// For Validation
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> errors=new ArrayList<>();
		for(FieldError error:ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}
		for(ObjectError err:ex.getBindingResult().getGlobalErrors()) {
			errors.add(err.getDefaultMessage());
		}
		ErrorResponse err=new ErrorResponse(ex.getLocalizedMessage(),400,errors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
// General Exception	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handelAllExceptions(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getLocalizedMessage(),400));
	}
	
}
