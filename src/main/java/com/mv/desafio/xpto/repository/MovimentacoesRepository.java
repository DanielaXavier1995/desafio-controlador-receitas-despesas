package com.mv.desafio.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mv.desafio.xpto.model.Movimentacoes;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long>{
	
}
