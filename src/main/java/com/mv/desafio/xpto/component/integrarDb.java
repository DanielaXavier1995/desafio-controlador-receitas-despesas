package com.mv.desafio.xpto.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mv.desafio.xpto.service.IntegracaoService;

@Component
public class integrarDb implements CommandLineRunner { //Responsável por chamar o método run para executar a integração com o banco
	
	@Autowired
    private IntegracaoService integracaoService;

	@Override
	public void run(String... args) throws Exception {
		integracaoService.integrarDados();
	}

}
