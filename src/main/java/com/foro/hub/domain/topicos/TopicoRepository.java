package com.foro.hub.domain.topicos;

import com.foro.hub.domain.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByStatus(Status status, Pageable pageable);
}
