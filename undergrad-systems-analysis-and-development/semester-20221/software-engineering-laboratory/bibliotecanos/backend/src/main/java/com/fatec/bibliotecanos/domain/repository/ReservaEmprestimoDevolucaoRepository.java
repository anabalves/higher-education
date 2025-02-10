package com.fatec.bibliotecanos.domain.repository;

import com.fatec.bibliotecanos.domain.model.ReservaEmprestimoDevolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaEmprestimoDevolucaoRepository extends JpaRepository<ReservaEmprestimoDevolucao, Long> {

}
