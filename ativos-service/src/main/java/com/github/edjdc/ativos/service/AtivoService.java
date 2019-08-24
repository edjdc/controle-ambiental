package com.github.edjdc.ativos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revisions;
import org.springframework.security.access.prepost.PreAuthorize;

import com.github.edjdc.ativos.model.entity.Ativo;
import com.querydsl.core.types.Predicate;

public interface AtivoService {

	@PreAuthorize("hasRole('ADMIN')")
	Ativo findOne(Long id);

	@PreAuthorize("hasRole('ADMIN')")
	Page<Ativo> findAll(Predicate predicate, Pageable pageable);

	@PreAuthorize("hasRole('ADMIN')")
	Ativo create(Ativo ativo);

	@PreAuthorize("hasRole('ADMIN')")
	Ativo update(Long id, Ativo ativo);

	@PreAuthorize("hasRole('ADMIN')")
	void delete(Long id);
	
	@PreAuthorize("hasRole('ADMIN')")
	Revisions<Long, Ativo> findRevisions(Long id);
	
}
