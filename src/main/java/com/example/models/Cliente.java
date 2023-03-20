package com.example.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer idCliente;

	@Column(name = "nome")
	@NotBlank(message = "Campo nome não pode estar vazio.")
	private String nome;

	@Column(name = "bi")
	@NotBlank(message = "Campo BI não pode estar vazio.")
	private String bi;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<ServicoPrestado> servicosPrestados;

	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;
}
