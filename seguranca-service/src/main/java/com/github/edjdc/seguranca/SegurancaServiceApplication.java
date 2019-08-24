package com.github.edjdc.seguranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SegurancaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegurancaServiceApplication.class, args);
	}

}
