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
	
	@UpdateTimestamp //Gerar data automática;
	private Date dataDeCriacao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE) //um cliente pode ter mais de uma conta
	@JsonIgnoreProperties("cliente") //evita que os dados fiquem em loop;
	private List<Contas> listaDeContas;
	
	@ManyToOne //Cada cliente está ligada a um único endereço
	@JsonIgnoreProperties("cliente") //evita que os dados fiquem em loop;
	private Endereco endereco;

	public Long getId() {
		return id;
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

	public String getCpf() {
		return cpf;
	}

	public String getCnpj() {
		return cnpj;
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
		return listaDeContas;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	
}
