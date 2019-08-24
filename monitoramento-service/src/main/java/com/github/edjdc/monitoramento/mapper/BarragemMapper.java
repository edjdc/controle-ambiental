package com.github.edjdc.monitoramento.mapper;

import org.mapstruct.Mapper;

import com.github.edjdc.monitoramento.model.dto.BarragemDTO;
import com.github.edjdc.monitoramento.model.dto.CreateBarragemDTO;
import com.github.edjdc.monitoramento.model.dto.UpdateBarragemDTO;
import com.github.edjdc.monitoramento.model.entity.Barragem;

@Mapper
public interface BarragemMapper {

	Barragem toBarragem(BarragemDTO barragemDTO);

	Barragem toBarragem(CreateBarragemDTO createBarragemDTO);

	Barragem toBarragem(UpdateBarragemDTO updateBarragemDTO);

	BarragemDTO toBarragemDTO(Barragem barragem);
	
}
