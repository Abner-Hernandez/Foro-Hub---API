package com.foro.hub.domain.cursos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank
        @JsonAlias({"nombreCurso", "nombre_curso", "Nombre Curso"})
        String nombreCurso
) {
}
