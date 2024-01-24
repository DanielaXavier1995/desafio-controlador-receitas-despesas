package com.mv.desafio.xpto.service;

import org.springframework.stereotype.Service;

import com.mv.desafio.xpto.enums.TipoPessoa;
import com.mv.desafio.xpto.model.Clientes;

@Service
public class ClientesService {
	
	public void validarTipoPessoa(Clientes cliente) {

        if (cliente.getTipoPessoa() == TipoPessoa.PESSOA_FISICA && cliente.getCpf() == null) {
            throw new IllegalArgumentException("O CPF é obrigatório para pessoa física.");
        }

        if (cliente.getTipoPessoa() == TipoPessoa.PESSOA_JURIDICA && cliente.getCnpj() == null) {
            throw new IllegalArgumentException("O CNPJ é obrigatório para pessoa jurídica.");
        }
    }
 }
	
	

