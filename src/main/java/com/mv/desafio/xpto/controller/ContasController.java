package com.mv.desafio.xpto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.desafio.xpto.repository.ContasRepository;

@RestController
@RequestMapping("/contas")
public class ContasController {
	
	private ContasRepository contaRepository;

}
