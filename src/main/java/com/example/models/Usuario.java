package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    private Integer idUsuario;

    private String email;
    private String password;

}
