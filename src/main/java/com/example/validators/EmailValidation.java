package com.example.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class EmailValidation {
    private final String EXPRESSAO_REGULAR = "^(.+)@(\\S+)$";

    public boolean patternMatches(String emailAddress) {
        return Pattern.compile(EXPRESSAO_REGULAR)
                .matcher(emailAddress)
                .matches();
    }

}
