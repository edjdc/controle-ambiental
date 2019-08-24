package com.github.edjdc.monitoramento.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import com.github.edjdc.monitoramento.exception.RecordNotFoundException;
import com.github.edjdc.monitoramento.model.entity.Barragem;
import com.github.edjdc.monitoramento.repository.BarragemRepository;
import com.github.edjdc.monitoramento.service.BarragemService;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BarragemServiceImpl implements BarragemService {

	private final BarragemRepository barragemRepository;

	@Override
	public Barragem findOne(Long id) {
		return barragemRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public Page<Barragem> findAll(Predicate predicate, Pageable pageable) {
		return barragemRepository.findAll(predicate, pageable);
	}

	@Override
	public Barragem create(Barragem barragem) {
		return barragemRepository.save(barragem);
	}

	@Override
	public Barragem update(Long id, Barragem barragem) {
		if (!barragemRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		barragem.setId(id);
		barragemRepository.save(barragem);
		return barragemRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public void delete(Long id) {
		if (!barragemRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		barragemRepository.deleteById(id);
		
	}

	@Override
	public Revisions<Long, Barragem> findRevisions(Long id) {
		return barragemRepository.findRevisions(id);
	}

}
