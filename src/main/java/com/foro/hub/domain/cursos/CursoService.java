package com.foro.hub.domain.cursos;

import com.foro.hub.domain.NotFoundElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Curso crearCurso(DatosRegistroCurso datos) {
        Curso curso = new Curso(datos.nombreCurso());
        return cursoRepository.save(curso);
    }

    public Page<DatosRespuestaCurso> obtenerTodosLosCursos(Pageable pageable) {
        return cursoRepository.findAll(pageable).map(curso -> new DatosRespuestaCurso(curso.getId(), curso.getNombreCurso()));
    }

    public Curso obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Curso no encontrado"));
    }

    @Transactional
    public Curso actualizarCurso(Long id, DatosRegistroCurso datos) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new NotFoundElementException("Curso no encontrado"));
        curso.actualizarDatos(datos);
        return cursoRepository.save(curso);
    }

    @Transactional
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
