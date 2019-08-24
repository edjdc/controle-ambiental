package com.github.edjdc.monitoramento.controller.v1;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.history.Revisions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.edjdc.monitoramento.mapper.RegistroBarragemMapper;
import com.github.edjdc.monitoramento.model.dto.CreateRegistroBarragemDTO;
import com.github.edjdc.monitoramento.model.dto.RegistroBarragemDTO;
import com.github.edjdc.monitoramento.model.dto.UpdateRegistroBarragemDTO;
import com.github.edjdc.monitoramento.model.entity.RegistroBarragem;
import com.github.edjdc.monitoramento.service.RegistroBarragemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = { "Registros de Barragens" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/barragem-registros")
public class RegistroBarragemController {

	private final RegistroBarragemMapper registroBarragemMapper;
	private final RegistroBarragemService registroBarragemService;
	
	@ApiOperation("Criar registro de barragem")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public RegistroBarragemDTO create(@RequestBody @Valid CreateRegistroBarragemDTO createRegistroBarragemDTO) {
		RegistroBarragem registroBarragemCreated = registroBarragemService.create(registroBarragemMapper.toRegistroBarragem(createRegistroBarragemDTO));
		return registroBarragemMapper.toRegistroBarragemDTO(registroBarragemCreated);
	}

	@ApiOperation("Atualizar registro de barragem")
	@PutMapping("/{id}")
	public RegistroBarragemDTO update(@PathVariable Long id, @RequestBody @Valid UpdateRegistroBarragemDTO updateRegistroBarragemDTO) {
		RegistroBarragem registroBarragemUpdated = registroBarragemService.update(id, registroBarragemMapper.toRegistroBarragem(updateRegistroBarragemDTO));
		return registroBarragemMapper.toRegistroBarragemDTO(registroBarragemUpdated);
	}

	@ApiOperation("Deletar registro de barragem")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		registroBarragemService.delete(id);
	}

	@ApiOperation("Buscar todos os registros de barragens")
	@GetMapping
	public List<RegistroBarragemDTO> findAll() {
		return registroBarragemService.findAll().stream().map(registroBarragemMapper::toRegistroBarragemDTO).collect(Collectors.toList());
	}

	@ApiOperation("Buscar barragem pelo id")
	@GetMapping("/{id}")
	public RegistroBarragemDTO findOne(@PathVariable Long id) {
		return registroBarragemMapper.toRegistroBarragemDTO(registroBarragemService.findOne(id));
	}
	
	@ApiOperation("Buscar auditoria de registro de barragem pelo id")
	@GetMapping("/revisions/{id}")
	public Revisions<Long, RegistroBarragem> revisions(@PathVariable Long id) {
		return registroBarragemService.findRevisions(id);
	}

}
