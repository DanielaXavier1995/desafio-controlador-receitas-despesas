package com.mv.desafio.xpto.dtos.respostasDto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaContaDto {

	private String numeroDaAgencia;

	private String numeroDaContaCorrente;

	private String nomeDaInstituicao;

	private Double saldo;

	private Date dataCriacao;

	private RespostaClienteDto cliente;

	private List<RespostaMovimentacaoDto> listaDeMovimentacoes;

	public RespostaContaDto() {

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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public RespostaClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(RespostaClienteDto cliente) {
		this.cliente = cliente;
	}

	public List<RespostaMovimentacaoDto> getListaDeMovimentacoes() {
		return listaDeMovimentacoes;
	}

	public void setListaDeMovimentacoes(List<RespostaMovimentacaoDto> listaDeMovimentacoes) {
		this.listaDeMovimentacoes = listaDeMovimentacoes;
	}
}
