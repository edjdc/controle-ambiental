package com.github.edjdc.seguranca.task;

import java.math.BigDecimal;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.edjdc.seguranca.service.SegurancaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class SegurancaTask {

	private static final BigDecimal MAX_NIVEL_AGUA = BigDecimal.valueOf(5.0);
	private static final BigDecimal MAX_PRESSAO = BigDecimal.valueOf(10.0);
	
	private final SegurancaService segurancaService;
	
	
	
	@Scheduled(fixedDelay = 10000)
    public void scheduleAlarmeSeguranca() {
		segurancaService.findAllRegistroBarragem().stream().filter(rb -> 
			rb.getNivelAgua().compareTo(MAX_NIVEL_AGUA) >= 0 || rb.getPressao().compareTo(MAX_PRESSAO) >= 0
		).forEach(rb -> 
			log.warn("Disparar alarme para a barragem: " + rb.getBarragemId() + ". Nivel agua: " + rb.getNivelAgua() + ". Pressao: " + rb.getPressao())
		);
	
	}
}
