package com.mv.desafio.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mv.desafio.xpto.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
