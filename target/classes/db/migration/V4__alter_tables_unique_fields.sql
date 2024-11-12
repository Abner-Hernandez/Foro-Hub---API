ALTER TABLE usuarios
ADD UNIQUE (username);

ALTER TABLE cursos
ADD UNIQUE (nombre_curso);

ALTER TABLE topicos
ADD UNIQUE (titulo);