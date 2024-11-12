package com.foro.hub.domain.topicos;

import com.foro.hub.domain.Status;
import com.foro.hub.domain.cursos.DatosRespuestaCurso;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Status status,
        DatosRespuestaCurso curso
) {
    public DatosRespuestaTopico(Topico topic) {
        this(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getStatus(), new DatosRespuestaCurso(topic.getCurso().getId(), topic.getCurso().getNombreCurso()));
    }
}
