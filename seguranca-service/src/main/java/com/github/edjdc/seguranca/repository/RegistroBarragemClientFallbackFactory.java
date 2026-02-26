package com.github.edjdc.seguranca.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistroBarragemClientFallbackFactory {

    public RegistroBarragemClient fallback(Throwable cause) {
        return () -> {
            log.error("Fallback do RegistroBarragemClient", cause);
            return List.<RegistroBarragemDTO>of();
        };
    }
}
