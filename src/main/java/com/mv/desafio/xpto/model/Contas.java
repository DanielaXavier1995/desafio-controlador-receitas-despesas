package com.mv.desafio.xpto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_contas")
public class Contas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O numero da agencia é obrigatório.")
	@Size(max = 5, message = "O número da agencia deve conter entre 5 e 4 caracteres.")
	private String numeroDaAgencia;

	@NotBlank(message = "O numero da conta corrente é obrigatório.")
	@Size(max = 9, message = "O número da conta deve conter entre 7 e 9 caracteres.")
	private String numeroDaContaCorrente;
	
	@NotBlank(message = "O nome da instituição é obrigatório.")
	private String nomeDaInstituicao;
	
	private Double saldo;
	
	private boolean ativo;

	@ManyToOne //Cada conta está ligada a um único cliete
	@JsonIgnoreProperties("conta") //evita que os dados fiquem em loop;
	private Clientes cliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta", cascade = CascadeType.REMOVE) 
	@JsonIgnoreProperties("cliente") //evita que os dados fiquem em loop;
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
	
	public void setAtivo(boolean ativo) {
		this.ativo = true;
	}
	
	public void excluir() {
		this.ativo = false;
	}
}
