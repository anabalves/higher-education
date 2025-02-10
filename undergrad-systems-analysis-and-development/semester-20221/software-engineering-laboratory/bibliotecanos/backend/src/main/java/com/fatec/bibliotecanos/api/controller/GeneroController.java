package com.fatec.bibliotecanos.api.controller;

import com.fatec.bibliotecanos.api.dto.GeneroDTO;
import com.fatec.bibliotecanos.domain.service.GeneroServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/generos")
@Api(value = "/api/generos", tags = "Bibliotecanos API", description = "API Para Gerenciamento de Bibliotecas")
public class GeneroController {

    @Autowired
    private GeneroServiceImpl generoServiceImpl;

    @GetMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<Page<GeneroDTO>> findAll(Pageable pageable) {
        Page<GeneroDTO> list = generoServiceImpl.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<GeneroDTO> findById(@PathVariable Long id) {
        GeneroDTO dto = generoServiceImpl.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<GeneroDTO> insert(@RequestBody GeneroDTO dto) {
        dto = generoServiceImpl.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<GeneroDTO> update(@PathVariable Long id, @RequestBody GeneroDTO dto) {
        dto = generoServiceImpl.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        generoServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

}
