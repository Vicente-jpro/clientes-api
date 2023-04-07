package com.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ClienteDto {
    private Integer idCliente;
    private String nome;
    private String bi;
    private String dataCadastro;
}
