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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
