package com.foro.hub.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    ACTIVO,
    INACTIVO;

    @JsonCreator
    public static Status fromString(String value) {
        if (value != null) {
            for (Status status : Status.values()) {
                if (status.name().equalsIgnoreCase(value)) {
                    return status;
                }
            }
        }
        throw new IllegalArgumentException("Valor no válido: " + value);
    }
}