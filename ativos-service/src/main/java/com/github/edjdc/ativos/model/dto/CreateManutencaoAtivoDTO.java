package com.github.edjdc.ativos.model.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
