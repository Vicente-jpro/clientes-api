package com.example.exceptions;

public class DadosInvalidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DadosInvalidoException(String errorMessage) {
        super(errorMessage);
    }
}
