package com.github.edjdc.monitoramento.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("CreateRegistroBarragem")
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
