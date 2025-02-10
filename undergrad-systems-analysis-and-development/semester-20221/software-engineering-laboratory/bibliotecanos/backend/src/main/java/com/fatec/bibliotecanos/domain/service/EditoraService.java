package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.EditoraDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EditoraService {

    Page<EditoraDTO> findAllPaged(Pageable pageable);
    EditoraDTO findById(Long id);
    EditoraDTO insert(EditoraDTO dto);
    EditoraDTO update(Long id, EditoraDTO dto);
    void delete(Long id);

}
