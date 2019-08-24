package com.github.edjdc.seguranca.repository;

import java.util.List;

import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;

public class RegistroBarragemClientFallback implements RegistroBarragemClient {

	@Override
	public List<RegistroBarragemDTO> findAll() {
		return List.of();
	}

}
