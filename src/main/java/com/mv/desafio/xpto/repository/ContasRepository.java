package com.mv.desafio.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mv.desafio.xpto.model.Contas;

public interface ContasRepository extends JpaRepository<Contas, Long> {
	

}
