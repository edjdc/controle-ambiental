package com.github.edjdc.seguranca.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("RegistroBarragem")
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class RegistroBarragemDTO implements Serializable {

	private static final long serialVersionUID = -4257135668888985286L;
	
	private Long id;
	private Long barragemId;
	private BigDecimal nivelAgua;
	private BigDecimal pressao;
	private Integer version;
	
}
