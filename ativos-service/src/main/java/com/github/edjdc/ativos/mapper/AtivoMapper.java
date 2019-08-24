package com.github.edjdc.ativos.mapper;

import org.mapstruct.Mapper;

import com.github.edjdc.ativos.model.dto.AtivoDTO;
import com.github.edjdc.ativos.model.dto.CreateAtivoDTO;
import com.github.edjdc.ativos.model.dto.UpdateAtivoDTO;
import com.github.edjdc.ativos.model.entity.Ativo;

@Mapper
public interface AtivoMapper {

	Ativo toAtivo(AtivoDTO ativoDTO);

	Ativo toAtivo(CreateAtivoDTO createAtivoDTO);

	Ativo toAtivo(UpdateAtivoDTO updateAtivoDTO);

	AtivoDTO toAtivoDTO(Ativo ativo);
	
}
