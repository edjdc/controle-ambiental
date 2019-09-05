package com.github.edjdc.seguranca.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistroBarragemClientFallbackFactory implements FallbackFactory<RegistroBarragemClient> {

	@Override
	public RegistroBarragemClient create(Throwable cause) {
		return () -> {
				log.error(cause.getMessage(), cause);
				return List.of();
		};
	}

}
