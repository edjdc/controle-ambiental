package com.github.edjdc.ativos.exception.handler.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FieldError implements Serializable {

	private static final long serialVersionUID = -2025785453687433560L;

	private String field;
	private String error;

}