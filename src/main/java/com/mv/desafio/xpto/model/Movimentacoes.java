package com.mv.desafio.xpto.model;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import com.mv.desafio.xpto.enums.TipoDeMovimentacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_movimentacoes")
public class Movimentacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@UpdateTimestamp
	private Date data;

	private TipoDeMovimentacao tipo;

	private Double valor;

	@ManyToOne
	private Contas conta;

	public Movimentacoes() {

	}

	public Movimentacoes(TipoDeMovimentacao tipo, Double valor, Contas conta) {
		this.tipo = tipo;
		this.valor = valor;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoDeMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Contas getConta() {
		return conta;
	}

	public void setConta(Contas conta) {
		this.conta = conta;
	}
}
