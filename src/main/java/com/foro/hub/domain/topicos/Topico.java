package com.foro.hub.domain.topicos;

import com.foro.hub.domain.Status;
import com.foro.hub.domain.cursos.Curso;
import com.foro.hub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha_creacion", nullable = false, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Topico(DatosRegistroTopico topico, Usuario autor, Curso curso) {
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.status = topico.status();
        this.autor = autor;
        this.curso = curso;
    }

    public void actualizarDatos(@Valid DatosActualizarTopico datosActualizarTopico, Curso curso) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }

        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.status() != null) {
            this.status = datosActualizarTopico.status();
        }

        if (curso!= null) {
            this.curso = curso;
        }
    }

    public void desactivarTopico() {
        this.status = Status.INACTIVO;
    }

}
