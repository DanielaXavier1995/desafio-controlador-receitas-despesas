package com.mv.desafio.xpto.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CriarContaDto {

	@NotBlank(message = "O numero da agencia é obrigatório.")
	@Size(max = 5, message = "O número da agencia deve conter entre 5 e 4 caracteres.")
	private String numeroDaAgencia;

	@NotBlank(message = "O numero da conta corrente é obrigatório.")
	@Size(max = 9, message = "O número da conta deve conter entre 7 e 9 caracteres.")
	private String numeroDaContaCorrente;

	@NotBlank(message = "O nome da instituição é obrigatório.")
	private String nomeDaInstituicao;

	@NotNull(message = "O id do cliente é obrigatório.")
	private Long clienteId;

	public CriarContaDto() {

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

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
}
