package com.example.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.ClienteDto;
import com.example.dto.ServicoPrestadoDto;
import com.example.models.ServicoPrestado;

@Component
public class ServicoPrestadoConverter {

    @Autowired
    private ClienteConverter clienteConverter;

    public ServicoPrestadoDto converterServicoPrestado(ServicoPrestado servicoPrestado) {
        ClienteDto cliente = clienteConverter.converterCliente(servicoPrestado.getCliente());
        return ServicoPrestadoDto.builder()
                .idServicoPrestado(servicoPrestado.getIdServicoPrestado())
                .cliente(cliente)
                .descricao(servicoPrestado.getDescricao())
                .data(String.valueOf(servicoPrestado.getData()))
                .valor(servicoPrestado.getValor())
                .build();
    }

}
