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
public class UpdateRegistroBarragemDTO implements Serializable {

	private static final long serialVersionUID = 8402563095886995303L;

	@NotNull
	private Long barragemId;

	@NotNull
	private BigDecimal nivelAgua;
	
	@NotNull
	private BigDecimal pressao;

	@NotNull
	private Integer version;
	
}
