package com.mv.desafio.xpto.dtos;

import com.mv.desafio.xpto.enums.TipoDeMovimentacao;

public class RespostaGenericaDto {

	private String mensagem;
	

	public RespostaGenericaDto(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public RespostaGenericaDto() {
		
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
