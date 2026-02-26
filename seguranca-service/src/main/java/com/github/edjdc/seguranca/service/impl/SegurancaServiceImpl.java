package com.github.edjdc.seguranca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;
import com.github.edjdc.seguranca.repository.RegistroBarragemClient;
import com.github.edjdc.seguranca.service.SegurancaService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SegurancaServiceImpl implements SegurancaService {

    private final RegistroBarragemClient registroBarragemClient;

    @Override
    @CircuitBreaker(name = "monitoramentoService", fallbackMethod = "fallbackFindAllRegistroBarragem")
    public List<RegistroBarragemDTO> findAllRegistroBarragem() {
        return registroBarragemClient.findAll();
    }

    private List<RegistroBarragemDTO> fallbackFindAllRegistroBarragem(Throwable throwable) {
        log.error("Erro ao consumir monitoramento-service, fallback aplicado", throwable);
        return List.of();
    }
}
