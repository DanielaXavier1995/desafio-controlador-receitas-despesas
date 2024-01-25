package com.mv.desafio.xpto.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mv.desafio.xpto.enums.TipoDeMovimentacao;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaMovimentacaoDto {
	
	private Date data;
	
	private TipoDeMovimentacao tipo;
	
	private Double valor;
	
	public RespostaMovimentacaoDto() {
		
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoDeMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
