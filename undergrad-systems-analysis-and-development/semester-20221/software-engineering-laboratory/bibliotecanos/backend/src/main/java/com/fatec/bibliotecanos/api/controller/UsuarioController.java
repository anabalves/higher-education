package com.fatec.bibliotecanos.api.controller;

import com.fatec.bibliotecanos.api.dto.UsuarioDTO;
import com.fatec.bibliotecanos.api.dto.request.AtualizarSenhaRequest;
import com.fatec.bibliotecanos.api.dto.request.AtualizarUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.request.RoleToUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.response.MessageResponse;
import com.fatec.bibliotecanos.api.dto.response.RoleToUsuarioResponse;
import com.fatec.bibliotecanos.domain.service.UsuarioServiceImpl;
import com.fatec.bibliotecanos.common.ApiValidations;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuarios")
@Api(value = "/api/usuarios", tags = "Bibliotecanos API", description = "API Para Gerenciamento de Bibliotecas")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<Page<UsuarioDTO>> findAll(Pageable pageable) {
        Page<UsuarioDTO> list = usuarioServiceImpl.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        UsuarioDTO dto = usuarioServiceImpl.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioRequest dto) {
        if (!ApiValidations.validarEmailAlternativo(dto.getEmailAlternativo())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O e-mail alternativo é inválido!"));
        }

        if (!ApiValidations.validarTelefone(dto.getTelefone())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O Telefone é inválido!"));
        }

        if (!ApiValidations.validarCep(dto.getCep())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O CEP é inválido!"));
        }

        UsuarioDTO newDto = usuarioServiceImpl.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PutMapping(value = "/update-role/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<RoleToUsuarioResponse> updateRole(@PathVariable Long id, @RequestBody @Valid RoleToUsuarioRequest dto) {
        RoleToUsuarioResponse newDto = usuarioServiceImpl.updateRole(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PutMapping(value = "/update-senha/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<UsuarioDTO> updateSenha(@PathVariable Long id, @RequestBody @Valid AtualizarSenhaRequest dto) {
        UsuarioDTO newDto = usuarioServiceImpl.updateSenha(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

}
