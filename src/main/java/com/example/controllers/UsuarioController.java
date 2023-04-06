package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Usuario;
import com.example.repositories.UsuarioRepository;
import com.example.services.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation("Salvar usuário.")
    @ApiResponse(code = 200, message = "Usuario criado")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@Valid @RequestBody Usuario usuario) {
        return this.usuarioService.save(usuario);
    }
}
