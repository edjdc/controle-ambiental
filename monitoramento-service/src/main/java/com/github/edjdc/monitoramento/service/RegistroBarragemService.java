package com.github.edjdc.monitoramento.service;

import java.util.List;

import org.springframework.data.history.Revisions;
import org.springframework.security.access.prepost.PreAuthorize;

import com.github.edjdc.monitoramento.model.entity.RegistroBarragem;

public interface RegistroBarragemService {

	@PreAuthorize("hasRole('ADMIN')")
	RegistroBarragem findOne(Long id);

	@PreAuthorize("hasRole('ADMIN')")
	List<RegistroBarragem> findAll();

	@PreAuthorize("hasRole('ADMIN')")
	RegistroBarragem create(RegistroBarragem registroBarragem);

	@PreAuthorize("hasRole('ADMIN')")
	RegistroBarragem update(Long id, RegistroBarragem registroBarragem);

	@PreAuthorize("hasRole('ADMIN')")
	void delete(Long id);
	
	@PreAuthorize("hasRole('ADMIN')")
	Revisions<Long, RegistroBarragem> findRevisions(Long id);
	
}
