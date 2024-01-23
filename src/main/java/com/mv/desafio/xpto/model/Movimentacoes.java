package com.mv.desafio.xpto.model;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mv.desafio.xpto.enums.TipoDeMovimentacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_movimentacoes")
public class Movimentacoes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull()
	private TipoDeMovimentacao tipoDeMovimentacao;
	
	@NotNull()
	private Double valorPagoMovimentacao;
	
	private Integer quantidadeDeMovimentacoes;
	
	@UpdateTimestamp
	private Date dataMovimentacoes;
	
	@ManyToOne 
	@JsonIgnoreProperties("conta") //evita que os dados fiquem em loop;
	private Contas conta;
}
