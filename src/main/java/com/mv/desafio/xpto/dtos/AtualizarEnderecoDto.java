package com.mv.desafio.xpto.dtos;

import jakarta.validation.constraints.NotBlank;

public class AtualizarEnderecoDto {
	
	private Long id;
	
	@NotBlank(message = "O nome da rua é obrigatório.")
	private String rua;
	
	@NotBlank(message = "O número é obrigatório.")
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "O bairro é obrigatório.")
	private String bairro;
	
	@NotBlank(message = "A cidade é obrigatória.")
	private String cidade;
	
	@NotBlank(message = "O UF é obrigatório.")
	private String uf;
	
	@NotBlank(message = "O CEP é obrigatório.")
	private String cep;

	public AtualizarEnderecoDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
