package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.UsuarioDTO;
import com.fatec.bibliotecanos.api.dto.request.AtualizarSenhaRequest;
import com.fatec.bibliotecanos.api.dto.request.AtualizarUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.request.RoleToUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.response.RoleToUsuarioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    Page<UsuarioDTO> findAllPaged(Pageable pageable);
    UsuarioDTO findById(Long id);
    UsuarioDTO update(Long id, AtualizarUsuarioRequest dto);
    RoleToUsuarioResponse updateRole(Long id, RoleToUsuarioRequest dto);
    UsuarioDTO updateSenha(Long id, AtualizarSenhaRequest dto);

}
