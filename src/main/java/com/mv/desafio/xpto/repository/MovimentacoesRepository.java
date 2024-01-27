package com.mv.desafio.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mv.desafio.xpto.model.Movimentacoes;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {
	@Query("SELECT COUNT(m.id) FROM Movimentacoes m " +
	           "JOIN m.conta c " +
	           "JOIN c.cliente cl " +
	           "WHERE c.dataCriacao BETWEEN CURRENT_DATE AND CURRENT_DATE + 30 " +
	           "AND cl.id = :clienteId")
	    Integer contarMovimentacoesPorClienteEPeriodo(@Param("clienteId") Long clienteId);
}
