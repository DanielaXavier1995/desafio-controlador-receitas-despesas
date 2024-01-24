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

@Entity
@Table(name = "tb_movimentacoes")
public class Movimentacoes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull()
	private TipoDeMovimentacao tipoDeMovimentacao;
	
	private Double valorTotalMovimentacao;
	
	private Integer quantidadeDeMovimentacoes;
	
	@UpdateTimestamp
	private Date dataMovimentacoes;
	
	@ManyToOne 
	@JsonIgnoreProperties("conta") //evita que os dados fiquem em loop;
	private Contas conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDeMovimentacao getTipoDeMovimentacao() {
		return tipoDeMovimentacao;
	}

	public void setTipoDeMovimentacao(TipoDeMovimentacao tipoDeMovimentacao) {
		this.tipoDeMovimentacao = tipoDeMovimentacao;
	}

	public Double getValorTotalMovimentacao() {
		return valorTotalMovimentacao;
	}

	public void setValorTotalMovimentacao(Double valorTotalMovimentacao) {
		this.valorTotalMovimentacao = valorTotalMovimentacao;
	}

	public Integer getQuantidadeDeMovimentacoes() {
		return quantidadeDeMovimentacoes;
	}

	public void setQuantidadeDeMovimentacoes(Integer quantidadeDeMovimentacoes) {
		this.quantidadeDeMovimentacoes = quantidadeDeMovimentacoes;
	}

	public Date getDataMovimentacoes() {
		return dataMovimentacoes;
	}

	public void setDataMovimentacoes(Date dataMovimentacoes) {
		this.dataMovimentacoes = dataMovimentacoes;
	}

	public Contas getConta() {
		return conta;
	}

	public void setConta(Contas conta) {
		this.conta = conta;
	}
}
