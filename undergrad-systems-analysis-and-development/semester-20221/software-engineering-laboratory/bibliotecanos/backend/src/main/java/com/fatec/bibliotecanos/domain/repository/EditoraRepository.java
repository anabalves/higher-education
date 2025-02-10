package com.fatec.bibliotecanos.domain.repository;

import com.fatec.bibliotecanos.domain.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

    Editora findByNome(String nome);

}
