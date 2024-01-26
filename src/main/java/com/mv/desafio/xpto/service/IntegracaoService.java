package com.mv.desafio.xpto.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.desafio.xpto.enums.TipoDeMovimentacao;
import com.mv.desafio.xpto.enums.TipoPessoa;
import com.mv.desafio.xpto.model.Clientes;
import com.mv.desafio.xpto.model.Contas;
import com.mv.desafio.xpto.model.Endereco;
import com.mv.desafio.xpto.model.Movimentacoes;
import com.mv.desafio.xpto.repository.ClientesRepository;
import com.mv.desafio.xpto.repository.ContasRepository;
import com.mv.desafio.xpto.repository.EnderecoRepository;
import com.mv.desafio.xpto.repository.MovimentacoesRepository;

import jakarta.transaction.Transactional;

@Service
public class IntegracaoService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private ContasRepository contasRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	@Transactional
	public void integrarDados() {
		//Endereco
		Endereco endereco1 = new Endereco(null, "rua 1", "123", "b1", "c1", "PE", "111111-111");
		Endereco endereco2 = new Endereco(null, "rua 2", "234", "b2", "c2", "PE", "22222-222");
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
		//Cliente
		Clientes cliente1 = new Clientes(null, "c1", TipoPessoa.PESSOA_FISICA, "111.111.111-11", null, "11111-1111", "c1@gmail.com", null, endereco1);
		Clientes cliente2 = new Clientes(null, "c2", TipoPessoa.PESSOA_JURIDICA, "22.222.222/0001-22", null, "22222-2222", "c1@gmail.com", null, endereco2);
		clientesRepository.saveAll(Arrays.asList(cliente1, cliente2));
		
		//Conta
		Contas conta1 = new Contas(null, "1111", "11111111-1", "b1", 1000.0, null, true, cliente1);
		Contas conta2 = new Contas(null, "2222", "22222222-2", "b2", 3000.0, null, true, cliente2);
		contasRepository.saveAll(Arrays.asList(conta1, conta2));
		
		//Movimentacões:
		
		//cliente1
		Movimentacoes movimentacao1 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 100.0, conta1);
		Movimentacoes movimentacao2 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 50.0, conta1);
		Movimentacoes movimentacao3 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 1000.0, conta1);
		Movimentacoes movimentacao4 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 1000.0, conta1);
		Movimentacoes movimentacao5 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 1000.0, conta1);
		Movimentacoes movimentacao6 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 1000.0, conta1);
		Movimentacoes movimentacao7 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 1000.0, conta1);
		Movimentacoes movimentacao8 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 1000.0, conta1);
		Movimentacoes movimentacao9 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 500.0, conta1);
		Movimentacoes movimentacao10 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 300.0, conta1);
		
		movimentacoesRepository.saveAll(Arrays.asList(
				movimentacao1, movimentacao2, movimentacao3, movimentacao4, movimentacao5, movimentacao6,
				movimentacao7, movimentacao8, movimentacao9, movimentacao10));
		
		//Cliente2
		Movimentacoes movimentacao11 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 1000.0, conta2);
		Movimentacoes movimentacao20 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 200.00, conta2);
		Movimentacoes movimentacao30 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 2000.0, conta2);
		Movimentacoes movimentacao40 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 1000.0, conta2);
		Movimentacoes movimentacao50 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 300.0, conta2);
		Movimentacoes movimentacao60 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 150.0, conta2);
		Movimentacoes movimentacao70 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA,1300.0, conta2);
		Movimentacoes movimentacao80 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 500.0, conta2);
		Movimentacoes movimentacao90 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 100.0, conta2);
		Movimentacoes movimentacao100 = new Movimentacoes(null, null, TipoDeMovimentacao.RECEITA, 350.0, conta2);
		Movimentacoes movimentacao110 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 1000.0, conta2);
		Movimentacoes movimentacao220 = new Movimentacoes(null, null, TipoDeMovimentacao.DESPESA, 1000.0, conta2);
		
		movimentacoesRepository.saveAll(Arrays.asList(
				movimentacao11, movimentacao20, movimentacao30, movimentacao40, movimentacao50, movimentacao60, 
				movimentacao70, movimentacao80, movimentacao90, movimentacao100, movimentacao110, movimentacao220));
		
		//Lista de clientes em endereço:
		endereco1.getListaDeClientes().add(cliente1);
		endereco2.getListaDeClientes().add(cliente2);
		
		//Lista de contas em cliente:
		cliente1.getListaDeContas().add(conta1);
		cliente2.getListaDeContas().add(conta2);
		
		//Lista de movimentacoes em conta1:
		conta1.getListaDeMovimentacoes().add(movimentacao1);
		conta1.getListaDeMovimentacoes().add(movimentacao2);
		conta1.getListaDeMovimentacoes().add(movimentacao3);
		conta1.getListaDeMovimentacoes().add(movimentacao4);
		conta1.getListaDeMovimentacoes().add(movimentacao5);
		conta1.getListaDeMovimentacoes().add(movimentacao6);
		conta1.getListaDeMovimentacoes().add(movimentacao7);
		conta1.getListaDeMovimentacoes().add(movimentacao8);
		conta1.getListaDeMovimentacoes().add(movimentacao9);
		conta1.getListaDeMovimentacoes().add(movimentacao10);
		
		//Lista de movimentacoes em conta1:
		conta2.getListaDeMovimentacoes().add(movimentacao11);
		conta2.getListaDeMovimentacoes().add(movimentacao20);
		conta2.getListaDeMovimentacoes().add(movimentacao30);
		conta2.getListaDeMovimentacoes().add(movimentacao40);
		conta2.getListaDeMovimentacoes().add(movimentacao50);
		conta2.getListaDeMovimentacoes().add(movimentacao60);
		conta2.getListaDeMovimentacoes().add(movimentacao70);
		conta2.getListaDeMovimentacoes().add(movimentacao80);
		conta2.getListaDeMovimentacoes().add(movimentacao90);
		conta2.getListaDeMovimentacoes().add(movimentacao100);
		conta2.getListaDeMovimentacoes().add(movimentacao110);
		conta2.getListaDeMovimentacoes().add(movimentacao220);
	}
}
