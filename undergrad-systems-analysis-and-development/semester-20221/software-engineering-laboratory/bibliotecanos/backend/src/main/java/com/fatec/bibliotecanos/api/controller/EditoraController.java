package com.fatec.bibliotecanos.api.controller;

import com.fatec.bibliotecanos.api.dto.EditoraDTO;
import com.fatec.bibliotecanos.domain.service.EditoraServiceImpl;
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
@RequestMapping(value = "/api/editoras")
@Api(value = "/api/editoras", tags = "Bibliotecanos API", description = "API Para Gerenciamento de Bibliotecas")
public class EditoraController {

    @Autowired
    private EditoraServiceImpl editoraService;

    @GetMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<Page<EditoraDTO>> findAll(Pageable pageable) {
        Page<EditoraDTO> list = editoraService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<EditoraDTO> findById(@PathVariable Long id) {
        EditoraDTO dto = editoraService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<EditoraDTO> insert(@RequestBody EditoraDTO dto) {
        dto = editoraService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<EditoraDTO> update(@PathVariable Long id, @RequestBody EditoraDTO dto) {
        dto = editoraService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        editoraService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
