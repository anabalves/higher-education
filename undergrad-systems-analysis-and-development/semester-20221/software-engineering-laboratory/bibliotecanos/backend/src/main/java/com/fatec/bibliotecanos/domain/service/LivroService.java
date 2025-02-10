package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.LivroDTO;
import com.fatec.bibliotecanos.api.dto.response.RelatorioAcervoResponse;
import com.fatec.bibliotecanos.api.dto.response.RelatorioEmprestimosResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LivroService {

    Page<LivroDTO> findAll(Pageable pageable);
    LivroDTO findById(Long id);
    LivroDTO insert(LivroDTO dto);
    LivroDTO update(Long id, LivroDTO dto);
    void delete(Long id);
    List<RelatorioAcervoResponse> relatorioAcervo();

}
