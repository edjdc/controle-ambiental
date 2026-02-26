package com.github.edjdc.seguranca.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;
import com.github.edjdc.seguranca.service.SegurancaService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/seguranca")
public class SegurancaController {

	private final SegurancaService segurancaService;
	@GetMapping
	public List<RegistroBarragemDTO> findAllRegistroBarragem() {
		return segurancaService.findAllRegistroBarragem();
	}

}
