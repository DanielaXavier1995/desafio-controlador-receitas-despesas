package com.mv.desafio.xpto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_contas")
public class Contas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O numero da agencia é obrigatório.")
	@Size(max = 5, min = 4, message = "O número da agencia deve conter entre 5 e 4 caracteres.")
	private String numeroDaAgencia;
	
	@NotBlank(message = "O numero da conta corrente é obrigatório.")
	@Size(max = 9, min = 7, message = "O número da conta deve conter entre 7 e 9 caracteres.")
	private String numeroDaContaCorrente;
	
	@NotBlank(message = "O nome da instituição é obrigatório.")
	private String nomeDaInstituicao;
	
	private Double saldo;
	
	@ManyToOne //Cada conta está ligada a um único cliete
	@JsonIgnoreProperties("conta") //evita que os dados fiquem em loop;
	private Clientes cliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta", cascade = CascadeType.REMOVE) 
	@JsonIgnoreProperties("cliente") //evita que os dados fiquem em loop;
	private List<Movimentacoes> listaDeMovimentacoes;

}
