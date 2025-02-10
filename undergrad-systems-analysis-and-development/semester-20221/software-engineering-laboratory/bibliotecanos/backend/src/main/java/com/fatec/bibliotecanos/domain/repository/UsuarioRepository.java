package com.fatec.bibliotecanos.domain.repository;

import com.fatec.bibliotecanos.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    Boolean existsByCpf(String cpf);
    Boolean existsByEmail(String email);

}
