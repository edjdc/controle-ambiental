package com.github.edjdc.monitoramento.model.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class UpdateBarragemDTO implements Serializable {

	private static final long serialVersionUID = 8402563095886995303L;
	
	private String nome;

	@NotNull
	private Integer version;
	
}
