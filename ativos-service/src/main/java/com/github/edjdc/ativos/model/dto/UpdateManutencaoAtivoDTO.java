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

@ApiModel("UpdateManutencaoAtivo")
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
