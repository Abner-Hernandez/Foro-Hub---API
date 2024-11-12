package com.foro.hub.domain.topicos;

import com.foro.hub.domain.Status;
import com.foro.hub.domain.cursos.DatosRegistroCurso;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Status status,
        DatosRegistroCurso curso
) {
}
