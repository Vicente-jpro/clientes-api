package com.example.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Cliente;
import com.example.services.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ApiOperation("Salvar cliente.")
	@ApiResponse(code = 201, message = "Cliente criado com sucesso.")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@Valid @RequestBody Cliente cliente) {
		log.info("ClienteController - Salvar cliente.");
		return this.clienteService.salvar(cliente);
	}

	@PatchMapping("/{id_cliente}")
	@ApiOperation("Atualizar cliente.")
	@ApiResponse(code = 201, message = "Cliente atualizado com sucesso.")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente atualizar(@Valid @RequestBody Cliente cliente, @PathVariable("id_cliente") Integer IdCliente) {
		log.info("ClienteController - Atualizar cliente.");
		Cliente client = this.clienteService.getCliente(IdCliente);
		cliente.setIdCliente(client.getIdCliente());
		return this.clienteService.salvar(cliente);
	}

	@GetMapping(value = "/", produces = "application/json")
	@ApiOperation("Listar todos clientes.")
	@ApiResponse(code = 302, message = "Clientes encontrados com sucesso.")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Cliente> listarClientes() {
		log.info("ClienteController - Listar todos clientes.");
		return this.clienteService.listarClientes();
	}

	@GetMapping("/{id_cliente}")
	@ApiOperation("Buscar cliente.")
	@ApiResponse(code = 302, message = "Cliente encontrado com sucesso.")
	@ResponseStatus(HttpStatus.FOUND)
	public Cliente getCliente(@PathVariable("id_cliente") Integer IdCliente) {
		log.info("ClienteController - Buscar cliente.");
		return this.clienteService.getCliente(IdCliente);
	}

	@DeleteMapping("/{id_cliente}")
	@ApiOperation("Eliminar cliente.")
	@ApiResponse(code = 302, message = "Cliente encontrado com sucesso.")
	@ResponseStatus(HttpStatus.FOUND)
	public void eliminar(@PathVariable("id_cliente") Integer IdCliente) {
		log.info("ClienteController - Eliminar cliente.");
		this.clienteService.eliminar(IdCliente);
	}

}
