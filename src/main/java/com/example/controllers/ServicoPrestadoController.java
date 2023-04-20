package com.example.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.dto.ServicoPrestadoDto;
import com.example.models.ServicoPrestado;
import com.example.services.ServicoPrestadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/servico-prestados")
// @CrossOrigin("http://localhost:4200")
public class ServicoPrestadoController {

    @Autowired
    private ServicoPrestadoService servicoPrestadoService;

    @PostMapping
    @ApiOperation("Salvar servico prestado por um determinado cliente.")
    @ApiResponse(code = 201, message = "Servico criado com sucesso.")
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestadoDto salvar(@RequestBody @Valid ServicoPrestadoDto servicoPrestadoDto) {
        log.info("ServicoPrestadoController - Salvar prestação de servico. ");

        return this.servicoPrestadoService.salvar(servicoPrestadoDto);
    }

    @GetMapping("/search")
    @ApiOperation("Pesquisar servico prestado pelo cliente.")
    @ApiResponses({
            @ApiResponse(code = 302, message = "Servico encontrado."),
            @ApiResponse(code = 500, message = "Dados invalidos.")
    })
    @ResponseStatus(HttpStatus.FOUND)
    public List<ServicoPrestadoDto> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "A") String nome,
            @RequestParam(value = "data", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate data) {

        return this.servicoPrestadoService.findByNomeClienteOrData(nome + "%", data);
    }

    @GetMapping
    @ApiOperation("Listar todos os servicos prestados.")
    @ApiResponse(code = 200, message = "Servico encontrado.")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ServicoPrestadoDto> listarTodos() {
        return this.servicoPrestadoService.listarTodos();
    }
}
