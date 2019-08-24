package com.github.edjdc.monitoramento.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("UpdateRegistroBarragem")
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
