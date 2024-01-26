package com.mv.desafio.xpto.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String rua;

	private String numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String uf;

	private String cep;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco", cascade = CascadeType.REMOVE) // um cliente pode ter mais
																							// de uma conta
	private List<Clientes> listaDeClientes; // todos os endereços de clientes diferentes mas que possuem a mesma
											// residência

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

	public List<Clientes> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Clientes> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
}
