package com.example.converter;

import org.springframework.stereotype.Component;

import com.example.dto.ClienteDto;
import com.example.models.Cliente;

@Component
public class ClienteConverter {

    public ClienteDto converterCliente(Cliente cliente) {
        return ClienteDto.builder()
                .idCliente(cliente.getIdCliente())
                .nome(cliente.getNome())
                .bi(cliente.getBi())
                .dataCadastro(String.valueOf(cliente.getDataCadastro()))
                .build();
    }

}
