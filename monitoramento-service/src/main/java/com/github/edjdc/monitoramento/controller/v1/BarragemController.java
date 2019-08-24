package com.github.edjdc.monitoramento.controller.v1;

import javax.validation.Valid;

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

import com.github.edjdc.monitoramento.helper.web.jpa.PageDTO;
import com.github.edjdc.monitoramento.helper.web.jpa.PageMapper;
import com.github.edjdc.monitoramento.mapper.BarragemMapper;
import com.github.edjdc.monitoramento.model.dto.BarragemDTO;
import com.github.edjdc.monitoramento.model.dto.CreateBarragemDTO;
import com.github.edjdc.monitoramento.model.dto.UpdateBarragemDTO;
import com.github.edjdc.monitoramento.model.entity.Barragem;
import com.github.edjdc.monitoramento.service.BarragemService;
import com.querydsl.core.types.Predicate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = { "Barragens" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/barragens")
public class BarragemController {

	private final BarragemMapper barragemMapper;
	private final PageMapper pageMapper;
	private final BarragemService barragemService;
	
	@ApiOperation("Criar barragem")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public BarragemDTO create(@RequestBody @Valid CreateBarragemDTO createBarragemDTO) {
		Barragem barragemCreated = barragemService.create(barragemMapper.toBarragem(createBarragemDTO));
		return barragemMapper.toBarragemDTO(barragemCreated);
	}

	@ApiOperation("Atualizar barragem")
	@PutMapping("/{id}")
	public BarragemDTO update(@PathVariable Long id, @RequestBody @Valid UpdateBarragemDTO updateBarragemDTO) {
		Barragem barragemUpdated = barragemService.update(id, barragemMapper.toBarragem(updateBarragemDTO));
		return barragemMapper.toBarragemDTO(barragemUpdated);
	}

	@ApiOperation("Deletar barragem")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		barragemService.delete(id);
	}

	@ApiOperation("Buscar todos barragens")
	@GetMapping
	public PageDTO<BarragemDTO> findAll(@QuerydslPredicate(root = Barragem.class) Predicate predicate,
			@PageableDefault(sort = "id", direction = Direction.ASC, size = 10000) Pageable pageable) {
		Page<BarragemDTO> page = barragemService.findAll(predicate, pageable).map(barragemMapper::toBarragemDTO);
		return pageMapper.toPageDTO(page);
	}

	@ApiOperation("Buscar barragem pelo id")
	@GetMapping("/{id}")
	public BarragemDTO findOne(@PathVariable Long id) {
		return barragemMapper.toBarragemDTO(barragemService.findOne(id));
	}
	
	@ApiOperation("Buscar auditoria de barragem pelo id")
	@GetMapping("/revisions/{id}")
	public Revisions<Long, Barragem> revisions(@PathVariable Long id) {
		return barragemService.findRevisions(id);
	}

}
