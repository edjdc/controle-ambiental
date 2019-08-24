package com.github.edjdc.ativos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.github.edjdc.ativos.model.entity.ManutencaoAtivo;

public interface ManutencaoAtivoRepository extends JpaRepository<ManutencaoAtivo, Long>, RevisionRepository<ManutencaoAtivo, Long, Long>,
		QuerydslPredicateExecutor<ManutencaoAtivo> {

}
