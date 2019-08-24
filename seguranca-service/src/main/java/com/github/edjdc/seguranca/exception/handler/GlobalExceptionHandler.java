package com.github.edjdc.seguranca.exception.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.edjdc.seguranca.exception.DuplicatedRecordException;
import com.github.edjdc.seguranca.exception.RecordNotFoundException;
import com.github.edjdc.seguranca.exception.handler.dto.ExceptionResponse;
import com.github.edjdc.seguranca.exception.handler.dto.FieldError;
import com.github.edjdc.seguranca.helper.i18n.Translator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	private final Translator translator;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = RecordNotFoundException.class)
	public ExceptionResponse handlerRecordNotFoundException(RecordNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
        response.setError(translator.get("error.record_not_found"));
        response.setErrorDescription(translator.get("error.description.record_not_found"));
        return response;
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(value = DuplicatedRecordException.class)
	public ExceptionResponse handlerDuplicatedRecordException(DuplicatedRecordException ex) {
		ExceptionResponse response = new ExceptionResponse();
        response.setError(translator.get("error.record_duplicated"));
        response.setErrorDescription(translator.get("error.description.record_duplicated"));
        return response;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BindException.class)
	public ExceptionResponse handlerBindException(BindException ex) {
		List<FieldError> validErrors = ex.getFieldErrors().stream()
				.map(error -> new FieldError(error.getField(), error.getDefaultMessage()) )
				.collect(Collectors.toList());

		ExceptionResponse response = new ExceptionResponse();
        response.setError(translator.get("error.validation_errors"));
        response.setErrorDescription(translator.get("error.description.validation.errors"));
        response.setValidationErrors(validErrors);
		
        return response;
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(value = AccessDeniedException.class)
	public ExceptionResponse handlerAccessDeniedException(AccessDeniedException ex) {
		ExceptionResponse response = new ExceptionResponse();
        response.setError(translator.get("error.access_denied"));
        response.setErrorDescription(translator.get("error.description.access_denied"));
        return response;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ExceptionResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setError(translator.get("error.resource_not_found"));
        response.setErrorDescription(translator.get("error.description.resource_not_found"));
		return response;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ExceptionResponse handleException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setError(translator.get("error.internal_server_error"));
        response.setErrorDescription(translator.get("error.description.internal_server_error"));
		return response;
	}
	
}
