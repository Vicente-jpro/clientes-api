package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ClienteNotFoundException;
import com.example.models.Cliente;
import com.example.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente getCliente(Integer idCliente) {
		return this.clienteRepository
				.findById(idCliente)
				.orElseThrow( () -> new ClienteNotFoundException("Cliente não encontrado. Id invalido :"+idCliente));
	}
	
	public void eliminar(Integer idCliente) {
		 Cliente cliente = this.getCliente(idCliente);
		 this.clienteRepository.delete(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.clienteRepository.findAll();
	}
}
