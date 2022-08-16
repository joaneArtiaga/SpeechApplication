package com.example.speechapplication.exception;

import lombok.Getter;

@Getter
public class SpeechCustomException extends RuntimeException{

    private int code;

    public SpeechCustomException(String message, int code) {
        super(message);
        this.code = code;
    }
}
