package com.foro.hub.domain.topicos;

import com.foro.hub.domain.Status;
import com.foro.hub.domain.cursos.DatosRegistroCurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Status status,
        @NotNull
        DatosRegistroCurso curso
) {
}
