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

import com.mv.desafio.xpto.dtos.requisicoesDto.AtualizarEnderecoDto;
import com.mv.desafio.xpto.dtos.requisicoesDto.CriarEnderecoDto;
import com.mv.desafio.xpto.dtos.respostasDto.RespostaClienteDto;
import com.mv.desafio.xpto.dtos.respostasDto.RespostaEnderecoDto;
import com.mv.desafio.xpto.dtos.respostasDto.RespostaGenericaDto;
import com.mv.desafio.xpto.model.Endereco;
import com.mv.desafio.xpto.repository.EnderecoRepository;
import com.mv.desafio.xpto.util.MapearCamposUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	// Exibe um DTO
	@GetMapping
	public ResponseEntity<List<RespostaEnderecoDto>> getAll() {

		// Lista de Endereco(Model)
		List<Endereco> enderecoList = enderecoRepository.findAll();

		// Lista de Endereco(DTO)
		List<RespostaEnderecoDto> respostaEnderecoList = enderecoList.stream()
				.map(endereco -> mapearEnderecoModel(endereco)).collect(Collectors.toList());

		return ResponseEntity.ok(respostaEnderecoList);
	}

	// Exibe um DTO
	@GetMapping("/{id}")
	public ResponseEntity<RespostaEnderecoDto> getById(@PathVariable Long id) {

		// Buscar o id da conta recebido no path
		Optional<Endereco> endereco = enderecoRepository.findById(id);

		// Validar id
		if (endereco.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.status(HttpStatus.OK).body(mapearEnderecoModel(endereco.get()));

	}

	// Recebe Model Endereco e transforma em DTO
	private RespostaEnderecoDto mapearEnderecoModel(Endereco endereco) {

		// Endereco:
		RespostaEnderecoDto respostaEndereco = MapearCamposUtil.converterEndereco(endereco);

		// Lista de clientes:
		List<RespostaClienteDto> listaClientes = endereco.getListaDeClientes().stream()
				.map(cliente -> MapearCamposUtil.converterCliente(cliente)).collect(Collectors.toList());

		// Settar Lista de Clientes DTO no Endereco DTO:
		respostaEndereco.setListaDeClientes(listaClientes);

		return respostaEndereco;
	}

	/*
	 * Recebe um como parâmetro um DTO e transforma em um Model do tipo Endereco
	 * para persistir os dados no banco
	 */
	@PostMapping
	public ResponseEntity<RespostaGenericaDto> create(@Valid @RequestBody CriarEnderecoDto criarEndereco) {

		// Criar objeto Endereco:
		Endereco endereco = new Endereco();

		// Transformar CriarEnderecoDto na model Endereco:
		endereco.setRua(criarEndereco.getRua());
		endereco.setNumero(criarEndereco.getNumero());
		endereco.setComplemento(criarEndereco.getComplemento());
		endereco.setBairro(criarEndereco.getBairro());
		endereco.setCidade(criarEndereco.getCidade());
		endereco.setUf(criarEndereco.getUf());
		endereco.setCep(criarEndereco.getCep());

		// Salvar Entidade Endereco
		enderecoRepository.save(endereco);

		return ResponseEntity.status(HttpStatus.CREATED).body(new RespostaGenericaDto("Endereco Criado com sucesso!"));
	}

	@PutMapping("/{id}")
	public ResponseEntity<RespostaGenericaDto> update(@PathVariable Long id,
			@Valid @RequestBody AtualizarEnderecoDto atualizarEndereco) {

		// Buscar Endereco
		Optional<Endereco> endereco = enderecoRepository.findById(id);

		// Validar Endereco
		if (endereco.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		// Transformar AtualizarEnderecoDto na model Endereco:
		endereco.get().setRua(atualizarEndereco.getRua());

		if (Objects.nonNull(atualizarEndereco.getNumero())) {
			endereco.get().setNumero(atualizarEndereco.getNumero());
		}

		if (Objects.nonNull(atualizarEndereco.getComplemento())) {
			endereco.get().setComplemento(atualizarEndereco.getComplemento());
		}

		endereco.get().setBairro(atualizarEndereco.getBairro());
		endereco.get().setCidade(atualizarEndereco.getCidade());
		endereco.get().setUf(atualizarEndereco.getUf());
		endereco.get().setCep(atualizarEndereco.getCep());

		// Salvar Entidade Endereco atualizada:
		enderecoRepository.save(endereco.get());

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new RespostaGenericaDto("Endereco atualizado com sucesso!"));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);

		if (endereco.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		enderecoRepository.deleteById(id);
	}
}
