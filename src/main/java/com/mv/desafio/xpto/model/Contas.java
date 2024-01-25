package com.mv.desafio.xpto.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mv.desafio.xpto.enums.TipoDeMovimentacao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_contas")
public class Contas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String numeroDaAgencia;

	private String numeroDaContaCorrente;
	
	private String nomeDaInstituicao;
	
	private Double saldo;
	
	@UpdateTimestamp
	private Date dataCriacao;
	
	private boolean ativo;

	@ManyToOne //Cada conta está ligada a um único cliete
	private Clientes cliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta", cascade = CascadeType.REMOVE)  
	private List<Movimentacoes> listaDeMovimentacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroDaAgencia() {
		return numeroDaAgencia;
	}

	public void setNumeroDaAgencia(String numeroDaAgencia) {
		this.numeroDaAgencia = numeroDaAgencia;
	}

	public String getNumeroDaContaCorrente() {
		return numeroDaContaCorrente;
	}

	public void setNumeroDaContaCorrente(String numeroDaContaCorrente) {
		this.numeroDaContaCorrente = numeroDaContaCorrente;
	}

	public String getNomeDaInstituicao() {
		return nomeDaInstituicao;
	}

	public void setNomeDaInstituicao(String nomeDaInstituicao) {
		this.nomeDaInstituicao = nomeDaInstituicao;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacoes> getListaDeMovimentacoes() {
		return listaDeMovimentacoes;
	}

	public void setListaDeMovimentacoes(List<Movimentacoes> listaDeMovimentacoes) {
		this.listaDeMovimentacoes = listaDeMovimentacoes;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = true;
	}
}
