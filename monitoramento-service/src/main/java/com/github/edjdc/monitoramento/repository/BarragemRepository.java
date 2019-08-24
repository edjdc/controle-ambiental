package com.github.edjdc.monitoramento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;

import com.github.edjdc.monitoramento.model.entity.Barragem;

public interface BarragemRepository extends JpaRepository<Barragem, Long>, RevisionRepository<Barragem, Long, Long>,
		QuerydslPredicateExecutor<Barragem> {


}
