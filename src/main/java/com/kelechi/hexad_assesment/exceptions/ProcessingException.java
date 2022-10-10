package com.kelechi.hexad_assesment.exceptions;

import lombok.Data;

@Data
public class ProcessingException extends RuntimeException {
    private String message;
    public ProcessingException(String message) {
        this.message = message;
    }
}
