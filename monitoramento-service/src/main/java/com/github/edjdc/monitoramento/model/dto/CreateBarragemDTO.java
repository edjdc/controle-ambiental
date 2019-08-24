package com.github.edjdc.monitoramento.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("CreateBarragem")
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class CreateBarragemDTO implements Serializable {

	private static final long serialVersionUID = -4142898798361209021L;

	@NotBlank
	private String nome;
	
}
