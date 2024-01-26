package com.mv.desafio.xpto.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.mv.desafio.xpto.dtos.CriarClienteDTO;
import com.mv.desafio.xpto.dtos.RespostaClienteDto;
import com.mv.desafio.xpto.dtos.RespostaContaDto;
import com.mv.desafio.xpto.dtos.RespostaGenericaDto;
import com.mv.desafio.xpto.model.Clientes;
import com.mv.desafio.xpto.model.Endereco;
import com.mv.desafio.xpto.repository.ClientesRepository;
import com.mv.desafio.xpto.repository.EnderecoRepository;
import com.mv.desafio.xpto.service.ClientesService;
import com.mv.desafio.xpto.util.MapearCamposUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClientesService clientesService;
	
	//Exibe um DTO
	@GetMapping
	public ResponseEntity<List<RespostaClienteDto>> getAll() {
		
		//Lista de Clientes(Model)
		List<Clientes> clienteList = clientesRepository.findAll();
				
		//Lista de contas(DTO)
		List<RespostaClienteDto> respostaClienteList = clienteList.stream()
			 .map(cliente -> mapearCliente(cliente))
			 .collect(Collectors.toList());
				
		return ResponseEntity.ok(respostaClienteList);
	}
	
	//Exibe um DTO
	@GetMapping("/{id}")
	public ResponseEntity<RespostaClienteDto> getById(@PathVariable Long id) {
		
		//Buscar o id da conta recebido no path 
		Optional<Clientes> cliente = clientesRepository.findById(id);
				
		//Validar id
		if(cliente.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
				
		//Retorna o método privado mapearConta que transforma uma Entidade Cliente em DTO
		return ResponseEntity.status(HttpStatus.OK).body(mapearCliente(cliente.get()));
	}
	
    private RespostaClienteDto mapearCliente(Clientes cliente) {
		
		//Converções:
		
		//cliente:
		RespostaClienteDto respostaCliente = MapearCamposUtil.converterCliente(cliente);
				
		//objeto endereco:
		respostaCliente.setEndereco(MapearCamposUtil.converterEndereco(cliente.getEndereco()));
				
		//lista de contas:
		List<RespostaContaDto> listaConta = cliente.getListaDeContas() 
			.stream() 
			.map(conta -> MapearCamposUtil.converterConta(conta)) 
			.collect(Collectors.toList());
				
		respostaCliente.setListaDeContas(listaConta);
		
		return respostaCliente;
	}
	
    //Recebe um DTO e transforma em um Model do tipo Cliente para persistir os dados no banco
	@PostMapping
	public ResponseEntity<RespostaGenericaDto> create(@Valid @RequestBody CriarClienteDTO criarcliente) {
	
		//Validar PF ou PJ
		clientesService.validarTipoPessoa(criarcliente);
		
		//Objeto Cliente
		Clientes cliente = new Clientes();
		
		//Transformar DTO em model:
		cliente.setNome(criarcliente.getNome());
		cliente.setTipoPessoa(criarcliente.getTipoPessoa());
		cliente.setCpf(criarcliente.getCpf());
		cliente.setCnpj(criarcliente.getCnpj());
		cliente.setTelefone(criarcliente.getTelefone());
		cliente.setEmail(criarcliente.getEmail());
		
		//Buscar endereco
		Optional<Endereco> endereco = enderecoRepository.findById(criarcliente.getEnderecoId());
						
		//Validar endereco
		if(endereco.isEmpty()) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	    cliente.setEndereco(endereco.get());
		
		//Salvar cliente
		Clientes clienteCriado = clientesRepository.save(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				 .body(new RespostaGenericaDto("Cliente criado com sucesso!"));

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RespostaGenericaDto> update(@PathVariable Long id, @Valid @RequestBody AtualizarClienteDto atualizarCliente) {
		
		//Buscar Cliente
		Optional<Clientes> cliente = clientesRepository.findById(id);
		
		//Validar Cliente
		if(cliente.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	    
		//Valida se os campos não vem nulos e atualiza
		if(Objects.nonNull(atualizarCliente.getNome())) {
			cliente.get().setNome(atualizarCliente.getNome());
		}
		
		if(Objects.nonNull(atualizarCliente.getTelefone())) {
			cliente.get().setTelefone(atualizarCliente.getTelefone());
		}
		
		if(Objects.nonNull(atualizarCliente.getEmail())) {
			cliente.get().setEmail(atualizarCliente.getEmail());

		}
		
		clientesRepository.save(cliente.get());
		
		return ResponseEntity.status(HttpStatus.OK)
    			.body(new RespostaGenericaDto("Cliente atualizado com sucesso!"));
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
