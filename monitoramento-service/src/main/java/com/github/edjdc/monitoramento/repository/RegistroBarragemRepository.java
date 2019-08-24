package com.github.edjdc.monitoramento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;

import com.github.edjdc.monitoramento.model.entity.RegistroBarragem;

public interface RegistroBarragemRepository extends JpaRepository<RegistroBarragem, Long>, RevisionRepository<RegistroBarragem, Long, Long>,
		QuerydslPredicateExecutor<RegistroBarragem> {


}
