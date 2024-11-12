package com.foro.hub.domain;

public class NotFoundElementException extends RuntimeException{
    public NotFoundElementException(String mensaje) {
        super(mensaje);
    }
}
