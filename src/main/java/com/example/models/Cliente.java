package com.example.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer idCliente;
	
	@Column( name = "nome")
	private String nome;
	
	@Column( name = "bi")
	private String bi;
	
	@Column( name = "data_cadastro")
	private LocalDate dataCadastro;
}
