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
import com.github.edjdc.ativos.mapper.AtivoMapper;
import com.github.edjdc.ativos.model.dto.AtivoDTO;
import com.github.edjdc.ativos.model.dto.CreateAtivoDTO;
import com.github.edjdc.ativos.model.dto.UpdateAtivoDTO;
import com.github.edjdc.ativos.model.entity.Ativo;
import com.github.edjdc.ativos.service.AtivoService;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/ativos")
public class AtivoController {

	private final AtivoMapper ativoMapper;
	private final PageMapper pageMapper;
	private final AtivoService ativoService;
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public AtivoDTO create(@RequestBody @Valid CreateAtivoDTO createAtivoDTO) {
		Ativo ativoCreated = ativoService.create(ativoMapper.toAtivo(createAtivoDTO));
		return ativoMapper.toAtivoDTO(ativoCreated);
	}
	@PutMapping("/{id}")
	public AtivoDTO update(@PathVariable Long id, @RequestBody @Valid UpdateAtivoDTO updateAtivoDTO) {
		Ativo ativoUpdated = ativoService.update(id, ativoMapper.toAtivo(updateAtivoDTO));
		return ativoMapper.toAtivoDTO(ativoUpdated);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		ativoService.delete(id);
	}
	@GetMapping
	public PageDTO<AtivoDTO> findAll(@QuerydslPredicate(root = Ativo.class) Predicate predicate,
			@PageableDefault(sort = "id", direction = Direction.ASC, size = 10000) Pageable pageable) {
		Page<AtivoDTO> page = ativoService.findAll(predicate, pageable).map(ativoMapper::toAtivoDTO);
		return pageMapper.toPageDTO(page);
	}
	@GetMapping("/{id}")
	public AtivoDTO findOne(@PathVariable Long id) {
		return ativoMapper.toAtivoDTO(ativoService.findOne(id));
	}
	@GetMapping("/revisions/{id}")
	public Revisions<Long, Ativo> revisions(@PathVariable Long id) {
		return ativoService.findRevisions(id);
	}

}
