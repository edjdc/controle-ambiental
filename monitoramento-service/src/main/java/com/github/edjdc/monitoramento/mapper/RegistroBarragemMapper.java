package com.github.edjdc.monitoramento.mapper;

import org.mapstruct.Mapper;

import com.github.edjdc.monitoramento.model.dto.CreateRegistroBarragemDTO;
import com.github.edjdc.monitoramento.model.dto.RegistroBarragemDTO;
import com.github.edjdc.monitoramento.model.dto.UpdateRegistroBarragemDTO;
import com.github.edjdc.monitoramento.model.entity.RegistroBarragem;

@Mapper
public interface RegistroBarragemMapper {

	RegistroBarragem toRegistroBarragem(RegistroBarragemDTO registroBarragemDTO);

	RegistroBarragem toRegistroBarragem(CreateRegistroBarragemDTO createRegistroBarragemDTO);

	RegistroBarragem toRegistroBarragem(UpdateRegistroBarragemDTO updateRegistroBarragemDTO);

	RegistroBarragemDTO toRegistroBarragemDTO(RegistroBarragem registroBarragem);
	
}
