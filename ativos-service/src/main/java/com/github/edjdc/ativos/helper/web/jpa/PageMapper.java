package com.github.edjdc.ativos.helper.web.jpa;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface PageMapper {

	default <T extends Serializable> PageDTO<T> toPageDTO(Page<T> page) {
		return new PageDTO<>(page);
	}
	
}
