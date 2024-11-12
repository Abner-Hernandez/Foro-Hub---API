package com.foro.hub.domain.topicos;

import com.foro.hub.domain.NotFoundElementException;
import com.foro.hub.domain.Status;
import com.foro.hub.domain.cursos.CursoRepository;
import com.foro.hub.domain.usuarios.Usuario;
import com.foro.hub.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Transactional
    public Topico crearTopico(DatosRegistroTopico datosRegistroTopico) {
        var usuario = usuarioRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName(), Usuario.class);
        var curso = cursoRepository.findByNombreCurso(datosRegistroTopico.curso().nombreCurso())
                .orElseThrow(() -> new NotFoundElementException("Curso no encontrado"));
        return topicoRepository.save(new Topico(datosRegistroTopico, usuario, curso));
    }

    @Transactional
    public Topico actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        var curso = cursoRepository.findByNombreCurso(datosActualizarTopico.curso().nombreCurso())
                .orElseThrow(() -> new NotFoundElementException("Curso no encontrado"));;
        Topico topic = topicoRepository.findById(datosActualizarTopico.id())
                .orElseThrow(() -> new NotFoundElementException("Topico no encontrado"));
        topic.actualizarDatos(datosActualizarTopico, curso);
        return topicoRepository.save(topic);
    }

    public Topico obtenerTopicoById(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Topico no encontrado"));
    }

    public Page<DatosRespuestaTopico> listarTopicosByPage(Pageable paginacion) {
        return topicoRepository.findByStatus(Status.ACTIVO, paginacion).map(DatosRespuestaTopico::new);
    }

    @Transactional
    public void eliminarTopico(Long id) {
        Topico topic = topicoRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Curso no encontrado"));;
        topic.desactivarTopico();
    }
}
