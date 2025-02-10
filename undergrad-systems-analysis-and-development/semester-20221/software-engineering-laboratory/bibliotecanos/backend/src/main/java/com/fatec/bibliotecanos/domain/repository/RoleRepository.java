package com.fatec.bibliotecanos.domain.repository;

import com.fatec.bibliotecanos.domain.model.Role;
import com.fatec.bibliotecanos.domain.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByAutorizacao(ERole autorizacao);

}
