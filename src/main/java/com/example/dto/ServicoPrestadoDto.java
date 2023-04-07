package com.example.dto;

import java.math.BigDecimal;

import com.example.models.Cliente;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ServicoPrestadoDto {

    private Integer idServicoPrestado;
    private String descricao;
    private BigDecimal valor;
    private String data;
    private ClienteDto cliente;

}
