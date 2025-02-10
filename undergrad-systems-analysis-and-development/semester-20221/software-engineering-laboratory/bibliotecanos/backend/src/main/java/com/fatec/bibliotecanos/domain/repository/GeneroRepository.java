package com.fatec.bibliotecanos.domain.repository;

import com.fatec.bibliotecanos.domain.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    Genero findByNome(String nome);

}
