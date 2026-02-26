package com.github.edjdc.ativos.model.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class CreateAtivoDTO implements Serializable {

	private static final long serialVersionUID = -4142898798361209021L;

	@NotBlank
	private String nome;
	
}
