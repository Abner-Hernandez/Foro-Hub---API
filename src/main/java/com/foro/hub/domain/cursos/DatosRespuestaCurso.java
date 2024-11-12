package com.foro.hub.domain.cursos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosRespuestaCurso(
        Long id,
        @JsonAlias("Nombre Curso")
        @JsonProperty("Nombre Curso")
        String nombreCurso
) {
}