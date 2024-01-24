package com.mv.desafio.xpto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mv.desafio.xpto.model.Contas;
import com.mv.desafio.xpto.repository.ContasRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContasController {
	
	@Autowired
	private ContasRepository contaRepository;
	
	@GetMapping
	public ResponseEntity<List<Contas>> getAll() {
		return ResponseEntity.ok(contaRepository.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Contas> getById(@PathVariable Long id) {
		return contaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Contas> post(@Valid @RequestBody Contas conta) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(contaRepository.save(conta));
		
	}
	
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 @Transactional
	 @DeleteMapping("/{id}")
	 public void delete (@PathVariable Long id) {
		Optional<Contas> conta = contaRepository.findById(id);
			
			if(conta.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			
		var buscarConta = contaRepository.getReferenceById(id);
			
		buscarConta.excluir();
	 }
}
