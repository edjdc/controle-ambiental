package com.github.edjdc.ativos.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class AtivoDTO implements Serializable {

	private static final long serialVersionUID = -4257135668888985286L;
	
	private Long id;
	private String nome;
	private LocalDateTime createdDate;
	private LocalDateTime lastModifiedDate;
	private String createdBy;
	private String lastModifiedBy;
	private Integer version;
	
}
