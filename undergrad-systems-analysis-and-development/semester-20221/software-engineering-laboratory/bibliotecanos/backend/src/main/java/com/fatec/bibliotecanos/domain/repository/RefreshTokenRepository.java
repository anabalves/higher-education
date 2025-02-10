package com.fatec.bibliotecanos.domain.repository;

import com.fatec.bibliotecanos.domain.model.RefreshToken;
import com.fatec.bibliotecanos.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUsuario(Usuario usuario);
}