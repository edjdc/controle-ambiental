package com.github.edjdc.ativos.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("CreateManutencaoAtivo")
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class CreateManutencaoAtivoDTO implements Serializable {

	private static final long serialVersionUID = -4142898798361209021L;

	@NotNull
	private Long ativoId;
	@NotBlank
	private String observacao;
	@NotNull
	private Date dataAgendamento;
	private Date dataManutencao;
	
}
