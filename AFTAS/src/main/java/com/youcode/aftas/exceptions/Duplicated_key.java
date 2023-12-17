package com.youcode.aftas.exceptions;

import lombok.AllArgsConstructor;

import org.springframework.dao.DuplicateKeyException;

public class Duplicated_key extends DuplicateKeyException {
    public Duplicated_key(String message) {
        super(message);
    }
}
