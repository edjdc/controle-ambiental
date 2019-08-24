package com.github.edjdc.ativos.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import com.github.edjdc.ativos.exception.RecordNotFoundException;
import com.github.edjdc.ativos.model.entity.Ativo;
import com.github.edjdc.ativos.repository.AtivoRepository;
import com.github.edjdc.ativos.service.AtivoService;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AtivoServiceImpl implements AtivoService {

	private final AtivoRepository ativoRepository;

	@Override
	public Ativo findOne(Long id) {
		return ativoRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public Page<Ativo> findAll(Predicate predicate, Pageable pageable) {
		return ativoRepository.findAll(predicate, pageable);
	}

	@Override
	public Ativo create(Ativo ativo) {
		return ativoRepository.save(ativo);
	}

	@Override
	public Ativo update(Long id, Ativo ativo) {
		if (!ativoRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		ativo.setId(id);
		ativoRepository.save(ativo);
		return ativoRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public void delete(Long id) {
		if (!ativoRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		ativoRepository.deleteById(id);
		
	}

	@Override
	public Revisions<Long, Ativo> findRevisions(Long id) {
		return ativoRepository.findRevisions(id);
	}

}
