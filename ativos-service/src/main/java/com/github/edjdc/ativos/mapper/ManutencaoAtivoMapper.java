package com.github.edjdc.ativos.mapper;

import org.mapstruct.Mapper;

import com.github.edjdc.ativos.model.dto.CreateManutencaoAtivoDTO;
import com.github.edjdc.ativos.model.dto.ManutencaoAtivoDTO;
import com.github.edjdc.ativos.model.dto.UpdateManutencaoAtivoDTO;
import com.github.edjdc.ativos.model.entity.ManutencaoAtivo;

@Mapper
public interface ManutencaoAtivoMapper {

	ManutencaoAtivo toManutencaoAtivo(ManutencaoAtivoDTO ativoDTO);

	ManutencaoAtivo toManutencaoAtivo(CreateManutencaoAtivoDTO createAtivoDTO);

	ManutencaoAtivo toManutencaoAtivo(UpdateManutencaoAtivoDTO updateAtivoDTO);

	ManutencaoAtivoDTO toManutencaoAtivoDTO(ManutencaoAtivo ativo);
	
}
