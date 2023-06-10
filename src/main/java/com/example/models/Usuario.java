package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idUsuario;

    @Column(name = "username")
    @NotBlank(message = "Campo user name não pode estar vazio.")
    private String username;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Campo email não pode estar vazio.")
    private String email;

    @Column(name = "passwrd")
    @NotBlank(message = "Campo palavra pass não pode estar vazio.")
    private String passwrd;

}
