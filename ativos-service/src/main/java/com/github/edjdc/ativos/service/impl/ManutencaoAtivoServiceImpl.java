package com.github.edjdc.ativos.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import com.github.edjdc.ativos.exception.RecordNotFoundException;
import com.github.edjdc.ativos.model.entity.ManutencaoAtivo;
import com.github.edjdc.ativos.repository.ManutencaoAtivoRepository;
import com.github.edjdc.ativos.service.ManutencaoAtivoService;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ManutencaoAtivoServiceImpl implements ManutencaoAtivoService {

	private final ManutencaoAtivoRepository manutencaoAtivoRepository;

	@Override
	public ManutencaoAtivo findOne(Long id) {
		return manutencaoAtivoRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public Page<ManutencaoAtivo> findAll(Predicate predicate, Pageable pageable) {
		return manutencaoAtivoRepository.findAll(predicate, pageable);
	}

	@Override
	public ManutencaoAtivo create(ManutencaoAtivo manutencaoAtivo) {
		return manutencaoAtivoRepository.save(manutencaoAtivo);
	}

	@Override
	public ManutencaoAtivo update(Long id, ManutencaoAtivo manutencaoAtivo) {
		if (!manutencaoAtivoRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		manutencaoAtivo.setId(id);
		manutencaoAtivoRepository.save(manutencaoAtivo);
		return manutencaoAtivoRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public void delete(Long id) {
		if (!manutencaoAtivoRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		manutencaoAtivoRepository.deleteById(id);
		
	}

	@Override
	public Revisions<Long, ManutencaoAtivo> findRevisions(Long id) {
		return manutencaoAtivoRepository.findRevisions(id);
	}

}
