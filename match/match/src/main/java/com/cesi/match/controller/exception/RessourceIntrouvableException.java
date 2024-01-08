package com.cesi.match.controller.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceIntrouvableException extends RuntimeException{
    public RessourceIntrouvableException(String s){
        super(s);
    }
}
