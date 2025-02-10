package com.fatec.bibliotecanos.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RelatorioAcervoResponse {

    private Long id;
    private String titulo;
    private String autor;
    private String descricao;
    private String editora;
    private String genero;
    private LocalDate anoPublicacao;
    private String isbn;

}
