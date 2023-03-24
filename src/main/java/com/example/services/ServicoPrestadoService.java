package com.example.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.converter.ClienteConverter;
import com.example.converter.ServicoPrestadoConverter;
import com.example.dto.ClienteDto;
import com.example.dto.ServicoPrestadoDto;
import com.example.models.Cliente;
import com.example.models.ServicoPrestado;
import com.example.repositories.ClienteRepository;
import com.example.repositories.ServicoPrestadoRepository;
import com.example.utils.BigDecimalConverter;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ServicoPrestadoService {

    @Autowired
    private ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoPrestadoConverter servicoPrestadoConverter;

    @Transactional
    public ServicoPrestadoDto salvar(ServicoPrestadoDto servicoPrestadoDto) {
        log.info("ServicoPrestadoService - Salando a prestação de servico com id_cliente: "
                + servicoPrestadoDto.getCliente());
        Cliente cliente = this.clienteService.getCliente(servicoPrestadoDto.getCliente().getIdCliente());

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setDescricao(servicoPrestadoDto.getDescricao());
        servicoPrestado.setValor(servicoPrestadoDto.getValor());

        LocalDate data = LocalDate.parse(servicoPrestadoDto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        servicoPrestado.setData(data);

        this.servicoPrestadoRepository.save(servicoPrestado);

        ServicoPrestadoDto dto = servicoPrestadoConverter.converterServicoPrestado(servicoPrestado);

        return dto;
    }

}
