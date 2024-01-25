package com.mv.desafio.xpto.util;

import com.mv.desafio.xpto.dtos.RespostaClienteDto;
import com.mv.desafio.xpto.dtos.RespostaContaDto;
import com.mv.desafio.xpto.dtos.RespostaEnderecoDto;
import com.mv.desafio.xpto.dtos.RespostaMovimentacaoDto;
import com.mv.desafio.xpto.model.Clientes;
import com.mv.desafio.xpto.model.Contas;
import com.mv.desafio.xpto.model.Endereco;
import com.mv.desafio.xpto.model.Movimentacoes;

public class MapearCamposUtil {
	
	public static RespostaContaDto converterConta(Contas conta) {
		
		RespostaContaDto respostaConta = new RespostaContaDto();
		
		respostaConta.setNumeroDaAgencia(conta.getNumeroDaAgencia());
		respostaConta.setNumeroDaContaCorrente(conta.getNumeroDaContaCorrente());
		respostaConta.setNomeDaInstituicao(conta.getNomeDaInstituicao());
		respostaConta.setSaldo(conta.getSaldo());
		respostaConta.setDataCriacao(conta.getDataCriacao());
		
		return respostaConta;
	}
	
	public static RespostaClienteDto converterCliente(Clientes cliente) {
		
		RespostaClienteDto respostaCliente = new RespostaClienteDto();
		
		respostaCliente.setNome(cliente.getNome());
		respostaCliente.setTipoPessoa(cliente.getTipoPessoa());
		respostaCliente.setCpf(cliente.getCpf());
		respostaCliente.setCnpj(cliente.getCnpj());
		respostaCliente.setTelefone(cliente.getTelefone());
		respostaCliente.setEmail(cliente.getEmail());
		respostaCliente.setDataDeCriacao(cliente.getDataDeCriacao());
		
		return respostaCliente;
	}
	
	public static RespostaEnderecoDto converterEndereco (Endereco endereco) {
		
		RespostaEnderecoDto respostaEndereco = new RespostaEnderecoDto();
		respostaEndereco.setRua(endereco.getRua());
		respostaEndereco.setNumero(endereco.getNumero());
		respostaEndereco.setComplemento(endereco.getComplemento());
		respostaEndereco.setBairro(endereco.getBairro());
		respostaEndereco.setCidade(endereco.getCidade());
		respostaEndereco.setUf(endereco.getUf());
		respostaEndereco.setCep(endereco.getCep());
		
		return respostaEndereco;
	}
	
    public static RespostaMovimentacaoDto converterMovimentacao (Movimentacoes movimentacao) {
		
    	RespostaMovimentacaoDto respostaMovimentacao = new RespostaMovimentacaoDto();
    	respostaMovimentacao.setData(movimentacao.getData());
    	respostaMovimentacao.setTipo(movimentacao.getTipo());
    	respostaMovimentacao.setValor(movimentacao.getValor());
		
		return respostaMovimentacao;
	}
	
	

}
