package com.mv.desafio.xpto.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaEnderecoDto {

	private String rua;

	private String numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String uf;

	private String cep;

	private List<RespostaClienteDto> listaDeClientes;

	public RespostaEnderecoDto() {

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

	public List<RespostaClienteDto> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<RespostaClienteDto> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
}
