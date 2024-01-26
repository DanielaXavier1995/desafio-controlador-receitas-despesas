package com.mv.desafio.xpto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.mv.desafio.xpto.enums.TipoPessoa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private TipoPessoa tipoPessoa;

	private String cpf;

	private String cnpj;

	private String telefone;

	private String email;

	@UpdateTimestamp
	private Date dataDeCriacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE) // um cliente pode ter mais																				// de uma conta
	private List<Contas> listaDeContas;

	@ManyToOne // Cada cliente está ligado a um único endereço
	private Endereco endereco;
	
	public Clientes() {

	}

	public Clientes(Long id, String nome, TipoPessoa tipoPessoa, String cpf, String cnpj, String telefone, String email,
			Date dataDeCriacao, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.dataDeCriacao = dataDeCriacao;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Contas> getListaDeContas() {
		return listaDeContas = new ArrayList<>();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
