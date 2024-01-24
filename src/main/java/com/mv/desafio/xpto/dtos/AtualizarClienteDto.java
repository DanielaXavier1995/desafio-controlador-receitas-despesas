package com.mv.desafio.xpto.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AtualizarClienteDto {

	
	@NotBlank(message = "O Nome é obrigatório.")
	private String nome;
	
	@NotBlank(message = "O telefone é obrigatório.")
	@Size(max = 25)
	private String telefone;
	
	@NotBlank(message = "O email é obrigatório.")
	@Email(message = "O Email deve ser um email válido.")
	private String email;

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
	
}
