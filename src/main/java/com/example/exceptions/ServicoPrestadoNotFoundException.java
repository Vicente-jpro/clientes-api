package com.example.exceptions;

public class ServicoPrestadoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    ServicoPrestadoNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
