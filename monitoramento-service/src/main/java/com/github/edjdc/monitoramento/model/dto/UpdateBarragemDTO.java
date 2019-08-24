package com.github.edjdc.monitoramento.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("UpdateBarragem")
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class UpdateBarragemDTO implements Serializable {

	private static final long serialVersionUID = 8402563095886995303L;
	
	private String nome;

	@NotNull
	private Integer version;
	
}
