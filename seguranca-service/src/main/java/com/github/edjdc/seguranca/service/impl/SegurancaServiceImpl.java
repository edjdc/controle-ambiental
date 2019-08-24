package com.github.edjdc.seguranca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;
import com.github.edjdc.seguranca.repository.RegistroBarragemClient;
import com.github.edjdc.seguranca.service.SegurancaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SegurancaServiceImpl implements SegurancaService {
	
	private final RegistroBarragemClient registroBarragemClient;
	
	@Override
	public List<RegistroBarragemDTO> findAllRegistroBarragem() {
		return registroBarragemClient.findAll();
	}



}
