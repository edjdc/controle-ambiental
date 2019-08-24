package com.github.edjdc.ativos.model.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("ManutencaoAtivo")
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class ManutencaoAtivoDTO implements Serializable {

	private static final long serialVersionUID = -4257135668888985286L;
	
	private Long id;
	private Long ativoId;
	private String observacao;
	private Date dataAgendamento;
	private Date dataManutencao;
	private Integer version;
	
}
