package com.github.edjdc.seguranca.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.edjdc.seguranca.config.FeignConfig;
import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;

@FeignClient(name = "monitoramento-service", configuration = FeignConfig.class)
public interface RegistroBarragemClient {

    @GetMapping("/v1/barragem-registros")
    List<RegistroBarragemDTO> findAll();
}
