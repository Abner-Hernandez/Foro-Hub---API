package com.foro.hub.domain.cursos;

import com.foro.hub.domain.topicos.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_curso", nullable = false, length = 255)
    private String nombreCurso;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;  // Un curso tiene muchos tópicos

    public Curso(@NotBlank String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void actualizarDatos(DatosRegistroCurso datos) {
        if(datos.nombreCurso() != null) {
            this.nombreCurso = datos.nombreCurso();
        }
    }
}