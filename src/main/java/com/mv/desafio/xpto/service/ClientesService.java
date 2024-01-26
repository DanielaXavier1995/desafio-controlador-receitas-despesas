package com.mv.desafio.xpto.service;

import org.springframework.stereotype.Service;

import com.mv.desafio.xpto.dtos.CriarClienteDTO;
import com.mv.desafio.xpto.enums.TipoPessoa;

@Service
public class ClientesService {

	// Método para validar se estamos tratando de uma PF ou PJ
	public void validarTipoPessoa(CriarClienteDTO criarcliente) {

		if (criarcliente.getTipoPessoa() == TipoPessoa.PESSOA_FISICA && criarcliente.getCpf() == null) {
			throw new IllegalArgumentException("O CPF é obrigatório para pessoa física.");
		}

		if (criarcliente.getTipoPessoa() == TipoPessoa.PESSOA_JURIDICA && criarcliente.getCnpj() == null) {
			throw new IllegalArgumentException("O CNPJ é obrigatório para pessoa jurídica.");
		}
	}
}
