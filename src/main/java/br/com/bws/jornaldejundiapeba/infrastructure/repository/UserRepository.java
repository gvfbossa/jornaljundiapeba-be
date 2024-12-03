package br.com.bws.jornaldejundiapeba.infrastructure.repository;


import br.com.bws.jornaldejundiapeba.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

}
