package com.mv.desafio.xpto.dtos.respostasDTO;

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
