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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mv.desafio.xpto.model.Endereco;
import com.mv.desafio.xpto.repository.EnderecoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll() {
		return ResponseEntity.ok(enderecoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getById(@PathVariable Long id) {
		return enderecoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Endereco> create(@Valid @RequestBody Endereco endereco) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(enderecoRepository.save(endereco));
	}
	
	@PutMapping
	public ResponseEntity<Endereco> update(@Valid @RequestBody Endereco endereco) {
		return enderecoRepository.findById(endereco.getId())		
				.map(resp -> ResponseEntity.status(HttpStatus.OK)
					.body(enderecoRepository.save(endereco)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		
		if(endereco.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		enderecoRepository.deleteById(id);
	}
}
