package com.github.edjdc.ativos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;

import com.github.edjdc.ativos.model.entity.Ativo;

public interface AtivoRepository extends JpaRepository<Ativo, Long>, RevisionRepository<Ativo, Long, Long>,
		QuerydslPredicateExecutor<Ativo> {


}
