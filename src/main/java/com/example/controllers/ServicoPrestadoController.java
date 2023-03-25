package com.example.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ServicoPrestadoDto;
import com.example.models.ServicoPrestado;
import com.example.services.ServicoPrestadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/servico-prestado")
public class ServicoPrestadoController {

    @Autowired
    private ServicoPrestadoService servicoPrestadoService;

    @PostMapping
    @ApiOperation("Salvar servico prestado por um determinado cliente.")
    @ApiResponse(code = 201, message = "Servico criado com sucesso.")
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestadoDto salvar(@Valid @RequestBody ServicoPrestadoDto servicoPrestadoDto) {
        log.info("ServicoPrestadoController - Salvar prestação de servico. ");
        return this.servicoPrestadoService.salvar(servicoPrestadoDto);
    }

    @GetMapping
    @ApiOperation("Pesquisar servico prestado pelo cliente.")
    @ApiResponse(code = 302, message = "Servico encontrado.")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ServicoPrestadoDto> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "A") String nome,
            @RequestParam(value = "mes", required = false) LocalDate data) {

        return this.servicoPrestadoService.findByNomeClienteOrMes(nome + "%", data);
    }
}
