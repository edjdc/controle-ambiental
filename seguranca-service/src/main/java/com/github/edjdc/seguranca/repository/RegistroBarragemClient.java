package com.github.edjdc.seguranca.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.edjdc.seguranca.config.FeignConfig;
import com.github.edjdc.seguranca.model.dto.RegistroBarragemDTO;

@FeignClient(name = "monitoramento-service", fallbackFactory = RegistroBarragemClientFallbackFactory.class, configuration = FeignConfig.class)
public interface RegistroBarragemClient {

	@RequestMapping(method = RequestMethod.GET, value = "/v1/barragem-registros")
	List<RegistroBarragemDTO> findAll();
	 
}


