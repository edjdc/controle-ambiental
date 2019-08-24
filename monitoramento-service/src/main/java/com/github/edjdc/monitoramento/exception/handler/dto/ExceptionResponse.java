package com.github.edjdc.monitoramento.exception.handler.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 3336740711374771623L;

	private String error;
	private String errorDescription;
	private List<FieldError> validationErrors;

}
