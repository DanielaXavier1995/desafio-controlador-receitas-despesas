package com.mv.desafio.xpto.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.desafio.xpto.dtos.respostasDTO.RespostaGenericaDto;
import com.mv.desafio.xpto.model.Clientes;
import com.mv.desafio.xpto.model.Contas;
import com.mv.desafio.xpto.repository.ClientesRepository;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

	@Autowired
	private ClientesRepository clientesRepository;

	@GetMapping("/saldo/clientes")
	public ResponseEntity<RespostaGenericaDto> getSaldoTodosClientes() {

		Date dataAtual = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // formatar data
		DecimalFormat df = new DecimalFormat("R$ #,##0.00"); // formatação de moeda brasileira

		List<Clientes> listaDeClientes = clientesRepository.findAll();

		// Gerar relatório:
		System.out.println("Relatório de saldo de todos os clientes:");
		// Iterar a lista de clientes:
		listaDeClientes.forEach(cliente -> {

			Double saldoTotal = 0.0;

			// Validar se lista de contas não é nula e vazia:
			if (Objects.nonNull(cliente.getListaDeContas()) && !cliente.getListaDeContas().isEmpty()) {
				// Calcular Saldo:
				saldoTotal = cliente.getListaDeContas().stream()
						// converte lista de obj contas em um lista de saldos (double)
						.mapToDouble(Contas::getSaldo)
						// responsalvel por iterar somando a lista de saldos
						.reduce(0, Double::sum);
			}

			// Mostrar informações:
			System.out.println("Cliente: " + cliente.getNome() + " - Cliente desde: "
					+ dateFormat.format(cliente.getDataDeCriacao()) + " – Saldo em " + dateFormat.format(dataAtual)
					+ ": " + df.format(saldoTotal));
		});

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new RespostaGenericaDto("Relatório de saldo dos clientes gerado com sucesso!"));
	}
}
