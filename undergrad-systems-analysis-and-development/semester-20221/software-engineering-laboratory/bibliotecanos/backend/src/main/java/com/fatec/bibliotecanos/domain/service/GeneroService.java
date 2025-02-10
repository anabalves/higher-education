package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.GeneroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneroService {

    Page<GeneroDTO> findAllPaged(Pageable pageable);
    GeneroDTO findById(Long id);
    GeneroDTO insert(GeneroDTO dto);
    GeneroDTO update(Long id, GeneroDTO dto);
    void delete(Long id);

}
