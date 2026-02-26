package com.github.edjdc.monitoramento.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class CreateRegistroBarragemDTO implements Serializable {

	private static final long serialVersionUID = -4142898798361209021L;

	@NotNull
	private Long barragemId;
	
	@NotNull
	private BigDecimal nivelAgua;
	
	@NotNull
	private BigDecimal pressao;
	
}
