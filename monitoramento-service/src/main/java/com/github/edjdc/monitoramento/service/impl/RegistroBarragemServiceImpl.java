package com.github.edjdc.monitoramento.service.impl;

import java.util.List;

import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import com.github.edjdc.monitoramento.exception.RecordNotFoundException;
import com.github.edjdc.monitoramento.model.entity.RegistroBarragem;
import com.github.edjdc.monitoramento.repository.RegistroBarragemRepository;
import com.github.edjdc.monitoramento.service.RegistroBarragemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegistroBarragemServiceImpl implements RegistroBarragemService {

	private final RegistroBarragemRepository registroBarragemRepository;

	@Override
	public RegistroBarragem findOne(Long id) {
		return registroBarragemRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public List<RegistroBarragem> findAll() {
		return registroBarragemRepository.findAll();
	}

	@Override
	public RegistroBarragem create(RegistroBarragem registroBarragem) {
		return registroBarragemRepository.save(registroBarragem);
	}

	@Override
	public RegistroBarragem update(Long id, RegistroBarragem registroBarragem) {
		if (!registroBarragemRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		registroBarragem.setId(id);
		registroBarragemRepository.save(registroBarragem);
		return registroBarragemRepository.findById(id).orElseThrow(RecordNotFoundException::new);
	}

	@Override
	public void delete(Long id) {
		if (!registroBarragemRepository.existsById(id)) {
			throw new RecordNotFoundException();
		}
		registroBarragemRepository.deleteById(id);
	}

	@Override
	public Revisions<Long, RegistroBarragem> findRevisions(Long id) {
		return registroBarragemRepository.findRevisions(id);
	}

}
