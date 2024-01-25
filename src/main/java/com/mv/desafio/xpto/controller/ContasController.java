package com.mv.desafio.xpto.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.mv.desafio.xpto.dtos.CriarContaDto;
import com.mv.desafio.xpto.dtos.RespostaContaDto;
import com.mv.desafio.xpto.dtos.RespostaGenericaDto;
import com.mv.desafio.xpto.dtos.RespostaMovimentacaoDto;
import com.mv.desafio.xpto.enums.TipoDeMovimentacao;
import com.mv.desafio.xpto.model.Clientes;
import com.mv.desafio.xpto.model.Contas;
import com.mv.desafio.xpto.model.Movimentacoes;
import com.mv.desafio.xpto.repository.ClientesRepository;
import com.mv.desafio.xpto.repository.ContasRepository;
import com.mv.desafio.xpto.repository.MovimentacoesRepository;
import com.mv.desafio.xpto.util.MapearCamposUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContasController {
	
	@Autowired
	private ContasRepository contaRepository;
	
	@Autowired
	private ClientesRepository clienteRepository;
	
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	//Exibe um DTO
	@GetMapping
	public ResponseEntity<List<RespostaContaDto>> getAll() {
		
		//Lista de contas(Model)
		List<Contas> contasList = contaRepository.findAll();
		
		//Lista de contas(DTO)
		List<RespostaContaDto> respostaContaList = contasList.stream()
				.map(conta -> mapearConta(conta))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(respostaContaList);
	}
	
	//Exibe um DTO
	@GetMapping("/{id}") 
	public ResponseEntity<RespostaContaDto> getById(@PathVariable Long id) {
		
		//Buscar o id da conta recebido no path 
		Optional<Contas> conta = contaRepository.findById(id);
		
		//Validar id
		if(conta.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		//Retorna o método privado mapearConta que transforma uma Entidade Contas em DTO
		return ResponseEntity.status(HttpStatus.OK).body(mapearConta(conta.get()));
	}
	
	private RespostaContaDto mapearConta(Contas conta) {
		
		//Converções:
		
		//conta:
		RespostaContaDto respostaConta = MapearCamposUtil.converterConta(conta);
				
		//cliente:
		respostaConta.setCliente(MapearCamposUtil.converterCliente(conta.getCliente()));
				
		//lista de movimentações:
		List<RespostaMovimentacaoDto> listaMovimentacao = conta.getListaDeMovimentacoes() 
			.stream() //Converter a lista de Movimentações
			.map(movimentacao -> MapearCamposUtil.converterMovimentacao(movimentacao)) 
			.collect(Collectors.toList());
				
		respostaConta.setListaDeMovimentacoes(listaMovimentacao);
		
		return respostaConta;
	}
	
	//Recebe um DTO e transforma em um Model do tipo Contas para persistir os dados no banco
	@PostMapping
	public ResponseEntity<RespostaGenericaDto> create(@Valid @RequestBody CriarContaDto criarConta) {
        
		//Buscar cliente
		Optional<Clientes> cliente = clienteRepository.findById(criarConta.getClienteId());
		
		//Validar cliente
		if(cliente.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		//Objeto conta
		Contas conta = new Contas();
		
		// Transformar DTO em model:
		conta.setNumeroDaAgencia(criarConta.getNumeroDaAgencia());
		conta.setNumeroDaContaCorrente(criarConta.getNumeroDaContaCorrente());
		conta.setNomeDaInstituicao(criarConta.getNomeDaInstituicao());
		conta.setSaldo(0.0);
		conta.setAtivo(true);
		conta.setCliente(cliente.get());
		
		//Salvar conta
		Contas contaCriada = contaRepository.save(conta);
		
		//Settar campos de movimentação para popular o banco de dados
		Movimentacoes movimentacao = new Movimentacoes();
		movimentacao.setTipo(TipoDeMovimentacao.RECEITA);
		movimentacao.setConta(contaCriada);
		movimentacao.setValor(0.0);
		
		//Salvar
		movimentacoesRepository.save(movimentacao);
		
		return ResponseEntity.status(HttpStatus.CREATED)
			   .body(new RespostaGenericaDto("Conta Criada com sucesso!"));
	  }
	
	 @DeleteMapping("/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void delete (@PathVariable Long id) {
		 
		//Buscar id
		Optional<Contas> conta = contaRepository.findById(id);
		
		//Validar id
		if(conta.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	    }
		
		//Deleção Lógica
		conta.get().setAtivo(false);
		
		contaRepository.save(conta.get());
	}
}
