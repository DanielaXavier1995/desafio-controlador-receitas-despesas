package com.mv.desafio.xpto.dtos;

import com.mv.desafio.xpto.model.Endereco;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class AtualizarClienteDto {

	private String nome;

	@Size(max = 25)
	private String telefone;

	@Email(message = "O Email deve ser um email válido.")
	private String email;

	private Endereco endereco;

	public AtualizarClienteDto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
}
