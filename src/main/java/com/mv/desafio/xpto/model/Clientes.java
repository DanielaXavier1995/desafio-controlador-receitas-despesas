package com.mv.desafio.xpto.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mv.desafio.xpto.enums.TipoDeMovimentacao;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_clientes")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Nome é obrigatório.")
	private String nome;
	
	@NotNull(message = "Informe o tipo de pessoa.")
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message = "O CPF é obrigatório.")
	@Size(max = 14, min = 14, message = "O CPF precisa conter 14 caracteres.")
	private String cpf;
	
	@NotBlank(message = "O CNPJ é obrigatório.")
	@Size(max = 18, min = 18, message = "O CPF precisa conter 18 caracteres.")
	private String cnpj;
	
	@NotBlank(message = "O telefone é obrigatório.")
	@Size(max = 15, min = 15, message = "O CPF precisa conter 15 caracteres.")
	private String telefone;
	
	@NotBlank(message = "O email é obrigatório.")
	@Email(message = "O Email deve ser um email válido.")
	private String email;
	
	@UpdateTimestamp //Gerar data automática;
	private Date dataDeCriacao;
	
	@NotNull()
	private TipoDeMovimentacao tipoDeMovimentacao;
	
	@NotNull()
	private Double valorDaMovimentacao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE) //um cliente pode ter mais de uma conta
	@JsonIgnoreProperties("cliente") //evita que os dados fiquem em loop;
	private List<Contas> listaDeContas;
	
	@ManyToOne //Cada cliente está ligada a um único endereço
	@JsonIgnoreProperties("cliente") //evita que os dados fiquem em loop;
	private Endereco endereco;

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

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public TipoDeMovimentacao getTipoDeMovimentacao() {
		return tipoDeMovimentacao;
	}

	public void setTipoDeMovimentacao(TipoDeMovimentacao tipoDeMovimentacao) {
		this.tipoDeMovimentacao = tipoDeMovimentacao;
	}

	public Double getValorDaMovimentacao() {
		return valorDaMovimentacao;
	}

	public void setValorDaMovimentacao(Double valorDaMovimentacao) {
		this.valorDaMovimentacao = valorDaMovimentacao;
	}

	public List<Contas> getListaDeContas() {
		return listaDeContas;
	}

	public void setListaDeContas(List<Contas> listaDeContas) {
		this.listaDeContas = listaDeContas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
