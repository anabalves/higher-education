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
public class RelatorioEmprestimosResponse {

    private Long id;
    private String nomeUsuario;
    private String titulo;
    private String situacao;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

}
