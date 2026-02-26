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
public class UpdateManutencaoAtivoDTO implements Serializable {

	private static final long serialVersionUID = 8402563095886995303L;

	@NotNull
	private Long ativoId;
	@NotBlank
	private String observacao;
	private Date dataAgendamento;
	private Date dataManutencao;
	private Integer version;
	
}
