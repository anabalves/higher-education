package com.fatec.bibliotecanos.api.controller;

import com.fatec.bibliotecanos.api.dto.LivroDTO;
import com.fatec.bibliotecanos.api.dto.response.RelatorioAcervoResponse;
import com.fatec.bibliotecanos.api.dto.response.RelatorioUsuariosResponse;
import com.fatec.bibliotecanos.domain.service.LivroServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/livros")
@Api(value = "/api/livros", tags = "Bibliotecanos API", description = "API Para Gerenciamento de Bibliotecas")
public class LivroController {

    @Autowired
    private LivroServiceImpl livroServiceImpl;

    @GetMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<Page<LivroDTO>> findAll(Pageable pageable) {
        Page<LivroDTO> list = livroServiceImpl.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<LivroDTO> findById(@PathVariable Long id) {
        LivroDTO dto = livroServiceImpl.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<LivroDTO> insert(@RequestBody LivroDTO dto) {
        dto = livroServiceImpl.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO dto) {
        dto = livroServiceImpl.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/relatorio-acervo")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<List<RelatorioAcervoResponse>> relatorioAcervo() {
        List<RelatorioAcervoResponse> list = livroServiceImpl.relatorioAcervo();
        return ResponseEntity.ok().body(list);
    }

}
