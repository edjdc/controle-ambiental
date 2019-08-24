package com.github.edjdc.seguranca.service;

import java.util.List;

import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;

public interface SegurancaService {

	List<RegistroBarragemDTO> findAllRegistroBarragem();
	
}
