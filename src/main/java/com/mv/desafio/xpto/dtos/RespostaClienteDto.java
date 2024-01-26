package com.mv.desafio.xpto.dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mv.desafio.xpto.enums.TipoPessoa;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaClienteDto {
	
	private String nome;
	
	private TipoPessoa tipoPessoa;
	
	private String cpf;
	
	private String cnpj;
	
	private String telefone;
	
	private String email;
	
	private Date dataDeCriacao;
	
	private List<RespostaContaDto> listaDeContas;
	
	private RespostaEnderecoDto endereco;
	
	public RespostaClienteDto() {
		
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

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public List<RespostaContaDto> getListaDeContas() {
		return listaDeContas;
	}

	public void setListaDeContas(List<RespostaContaDto> listaDeContas) {
		this.listaDeContas = listaDeContas;
	}

	public RespostaEnderecoDto getEndereco() {
		return endereco;
	}

	public void setEndereco(RespostaEnderecoDto endereco) {
		this.endereco = endereco;
	}
}
