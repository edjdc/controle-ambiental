package com.github.edjdc.ativos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revisions;
import org.springframework.security.access.prepost.PreAuthorize;

import com.github.edjdc.ativos.model.entity.ManutencaoAtivo;
import com.querydsl.core.types.Predicate;

public interface ManutencaoAtivoService {

	@PreAuthorize("hasRole('ADMIN')")
	ManutencaoAtivo findOne(Long id);

	@PreAuthorize("hasRole('ADMIN')")
	Page<ManutencaoAtivo> findAll(Predicate predicate, Pageable pageable);

	@PreAuthorize("hasRole('ADMIN')")
	ManutencaoAtivo create(ManutencaoAtivo ativo);

	@PreAuthorize("hasRole('ADMIN')")
	ManutencaoAtivo update(Long id, ManutencaoAtivo ativo);

	@PreAuthorize("hasRole('ADMIN')")
	void delete(Long id);
	
	@PreAuthorize("hasRole('ADMIN')")
	Revisions<Long, ManutencaoAtivo> findRevisions(Long id);
	
}
