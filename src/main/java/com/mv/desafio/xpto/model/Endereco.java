package com.mv.desafio.xpto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_enderecos")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco", cascade = CascadeType.REMOVE) //um cliente pode ter mais de uma conta
	@JsonIgnoreProperties("endereco") //evita que os dados fiquem em loop;
	private List<Clientes> listaDeClientes; //todos os endereços de clientes diferentes mas que possuem a mesma residência 
}
