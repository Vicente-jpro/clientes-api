package com.example.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ServicoPrestadoDto;
import com.example.models.Cliente;
import com.example.models.ServicoPrestado;
import com.example.repositories.ClienteRepository;
import com.example.repositories.ServicoPrestadoRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ServicoPrestadoService {

    @Autowired
    private ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    private ClienteService clienteService;

    public ServicoPrestado salvar(ServicoPrestadoDto servicoPrestadoDto) {
        log.info("ServicoPrestadoService - Salando a prestação de servico com id_cliente: "
                + servicoPrestadoDto.getCliente());
        Cliente cliente = this.clienteService.getCliente(servicoPrestadoDto.getCliente());

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setDescricao(servicoPrestadoDto.getDescricao());
        servicoPrestado.setValor(servicoPrestadoDto.getValor());

        LocalDate data = LocalDate.parse(servicoPrestadoDto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        servicoPrestado.setData(data);

        ServicoPrestado servico = this.servicoPrestadoRepository.save(servicoPrestado);
        return servico;
    }
}
