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

import com.mv.desafio.xpto.dtos.AtualizarClienteDto;
import com.mv.desafio.xpto.model.Clientes;
import com.mv.desafio.xpto.repository.ClientesRepository;
import com.mv.desafio.xpto.service.ClientesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private ClientesService clientesService;
	
	@GetMapping
	public ResponseEntity<List<Clientes>> getAll() {
		return ResponseEntity.ok(clientesRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clientes> getById(@PathVariable Long id) {
		return clientesRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Clientes> create(@Valid @RequestBody Clientes cliente) {
			
        clientesService.validarTipoPessoa(cliente);
        
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(clientesRepository.save(cliente));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Clientes> update(@PathVariable Long id, @Valid @RequestBody AtualizarClienteDto clienteDto) {
		
		Optional<Clientes> buscarCliente = clientesRepository.findById(id);
    	
		if(buscarCliente.isPresent()) {
			
			Clientes atualizarCliente = buscarCliente.get();   
			
			atualizarCliente.setNome(clienteDto.getNome());
			atualizarCliente.setTelefone(clienteDto.getTelefone());
			atualizarCliente.setEmail(clienteDto.getEmail());
			
    		//Incluir validação da conta posteriormente
    			return ResponseEntity.status(HttpStatus.OK)
    					.body(clientesRepository.save(atualizarCliente));
    	}
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	} 
	
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Long id) {
		Optional<Clientes> cliente = clientesRepository.findById(id);
			
			if(cliente.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			
		clientesRepository.deleteById(id);
	 }
}
