package com.github.edjdc.monitoramento.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revisions;
import org.springframework.security.access.prepost.PreAuthorize;

import com.github.edjdc.monitoramento.model.entity.Barragem;
import com.querydsl.core.types.Predicate;

public interface BarragemService {

	@PreAuthorize("hasRole('ADMIN')")
	Barragem findOne(Long id);

	@PreAuthorize("hasRole('ADMIN')")
	Page<Barragem> findAll(Predicate predicate, Pageable pageable);

	@PreAuthorize("hasRole('ADMIN')")
	Barragem create(Barragem barragem);

	@PreAuthorize("hasRole('ADMIN')")
	Barragem update(Long id, Barragem barragem);

	@PreAuthorize("hasRole('ADMIN')")
	void delete(Long id);
	
	@PreAuthorize("hasRole('ADMIN')")
	Revisions<Long, Barragem> findRevisions(Long id);
	
}
