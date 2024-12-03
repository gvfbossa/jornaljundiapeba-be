package br.com.bws.jornaldejundiapeba.infrastructure.repository;

import br.com.bws.jornaldejundiapeba.domain.model.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

    Page<Noticia> findAll(Pageable pageable);
}
