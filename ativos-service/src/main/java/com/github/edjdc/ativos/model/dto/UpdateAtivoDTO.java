package com.github.edjdc.ativos.model.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("UpdateAtivo")
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class UpdateAtivoDTO implements Serializable {

	private static final long serialVersionUID = 8402563095886995303L;
	
	private String nome;
	private Integer version;
	
}
