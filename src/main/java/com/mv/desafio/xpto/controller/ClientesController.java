package com.mv.desafio.xpto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mv.desafio.xpto.model.Clientes;
import com.mv.desafio.xpto.repository.ClientesRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@GetMapping
	public ResponseEntity<List<Clientes>> getAll() {
		return ResponseEntity.ok(clientesRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Clientes> post(@Valid @RequestBody Clientes cliente) {
		if(clientesRepository.existsById(cliente.getId()))
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(clientesRepository.save(cliente));
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não existe!", null);
	}

}
