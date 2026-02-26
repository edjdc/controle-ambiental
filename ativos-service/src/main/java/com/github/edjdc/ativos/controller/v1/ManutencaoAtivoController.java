package com.github.edjdc.ativos.controller.v1;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.history.Revisions;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
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

import com.github.edjdc.ativos.helper.web.jpa.PageDTO;
import com.github.edjdc.ativos.helper.web.jpa.PageMapper;
import com.github.edjdc.ativos.mapper.ManutencaoAtivoMapper;
import com.github.edjdc.ativos.model.dto.CreateManutencaoAtivoDTO;
import com.github.edjdc.ativos.model.dto.ManutencaoAtivoDTO;
import com.github.edjdc.ativos.model.dto.UpdateManutencaoAtivoDTO;
import com.github.edjdc.ativos.model.entity.Ativo;
import com.github.edjdc.ativos.model.entity.ManutencaoAtivo;
import com.github.edjdc.ativos.service.ManutencaoAtivoService;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/manutencao-ativos")
public class ManutencaoAtivoController {

	private final ManutencaoAtivoMapper manutencaoAtivoMapper;
	private final PageMapper pageMapper;
	private final ManutencaoAtivoService manutencaoAtivoService;
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ManutencaoAtivoDTO create(@RequestBody @Valid CreateManutencaoAtivoDTO createManutencaoAtivoDTO) {
		ManutencaoAtivo manutencaoAtivoCreated = manutencaoAtivoService.create(manutencaoAtivoMapper.toManutencaoAtivo(createManutencaoAtivoDTO));
		return manutencaoAtivoMapper.toManutencaoAtivoDTO(manutencaoAtivoCreated);
	}
	@PutMapping("/{id}")
	public ManutencaoAtivoDTO update(@PathVariable Long id, @RequestBody @Valid UpdateManutencaoAtivoDTO updateManutencaoAtivoDTO) {
		ManutencaoAtivo manutencaoAtivoUpdated = manutencaoAtivoService.update(id, manutencaoAtivoMapper.toManutencaoAtivo(updateManutencaoAtivoDTO));
		return manutencaoAtivoMapper.toManutencaoAtivoDTO(manutencaoAtivoUpdated);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		manutencaoAtivoService.delete(id);
	}
	@GetMapping
	public PageDTO<ManutencaoAtivoDTO> findAll(@QuerydslPredicate(root = Ativo.class) Predicate predicate,
			@PageableDefault(sort = "id", direction = Direction.ASC, size = 10000) Pageable pageable) {
		Page<ManutencaoAtivoDTO> page = manutencaoAtivoService.findAll(predicate, pageable).map(manutencaoAtivoMapper::toManutencaoAtivoDTO);
		return pageMapper.toPageDTO(page);
	}
	@GetMapping("/{id}")
	public ManutencaoAtivoDTO findOne(@PathVariable Long id) {
		return manutencaoAtivoMapper.toManutencaoAtivoDTO(manutencaoAtivoService.findOne(id));
	}
	@GetMapping("/revisions/{id}")
	public Revisions<Long, ManutencaoAtivo> revisions(@PathVariable Long id) {
		return manutencaoAtivoService.findRevisions(id);
	}

}
