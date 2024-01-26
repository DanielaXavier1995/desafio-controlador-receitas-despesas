package com.mv.desafio.xpto.dtos.requisicoesDTO;

import com.mv.desafio.xpto.enums.TipoPessoa;
import com.mv.desafio.xpto.model.Endereco;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CriarClienteDTO {

	@NotBlank(message = "O Nome é obrigatório.")
	private String nome;

	@NotNull(message = "Informe o tipo de pessoa.")
	private TipoPessoa tipoPessoa;

	@Size(max = 20)
	private String cpf;

	@Size(max = 25)
	private String cnpj;

	@NotBlank(message = "O telefone é obrigatório.")
	@Size(max = 25)
	private String telefone;

	@NotBlank(message = "O email é obrigatório.")
	@Email(message = "O Email deve ser um email válido.")
	private String email;

	@NotNull(message = "O endereço do cliente é obrigatório.")
	private Long enderecoId;

	private Endereco endereco;

	public CriarClienteDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}
}
