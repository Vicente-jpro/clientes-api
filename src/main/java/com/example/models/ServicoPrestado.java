package com.example.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "servico_prestado")
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idServicoPrestado;

    @Column(name = "descricao")
    @NotBlank(message = "Campo Descrição não pode estar vazio.")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_servico_prestado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

}
