package com.foro.hub.controller;

import com.foro.hub.domain.cursos.Curso;
import com.foro.hub.domain.cursos.CursoService;
import com.foro.hub.domain.cursos.DatosRegistroCurso;
import com.foro.hub.domain.cursos.DatosRespuestaCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> crearCurso(@RequestBody @Valid DatosRegistroCurso datos,
                                                          UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoService.crearCurso(datos);
        DatosRespuestaCurso cursoCreated = new DatosRespuestaCurso(curso.getId(), curso.getNombreCurso());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(cursoCreated.id()).toUri();
        return ResponseEntity.created(url).body(cursoCreated);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaCurso>> obtenerCursos(@PageableDefault(size = 2) Pageable paginacion) {
        Page<DatosRespuestaCurso> cursos = cursoService.obtenerTodosLosCursos(paginacion);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> obtenerCursoPorId(@PathVariable Long id) {
        Curso curso = cursoService.obtenerCursoPorId(id);
        DatosRespuestaCurso respuesta = new DatosRespuestaCurso(curso.getId(), curso.getNombreCurso());
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> actualizarCurso(@PathVariable Long id,
                                                               @RequestBody @Valid DatosRegistroCurso datos) {
        Curso cursoActualizado = cursoService.actualizarCurso(id, datos);
        DatosRespuestaCurso respuesta = new DatosRespuestaCurso(cursoActualizado.getId(), cursoActualizado.getNombreCurso());
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
