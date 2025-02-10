package com.fatec.bibliotecanos.api.dto;

import com.fatec.bibliotecanos.domain.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LivroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String titulo;
    private String descricao;
    private String autor;
    private Integer edicao;
    private String isbn;
    private Integer quantidade;
    private String imgUrl;
    private LocalDate anoPublicacao;
    private Long generoId;
    private Long editoraId;

    public LivroDTO(Livro entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        descricao = entity.getDescricao();
        autor = entity.getAutor();
        edicao = entity.getEdicao();
        isbn = entity.getIsbn();
        quantidade = entity.getQuantidade();
        imgUrl = entity.getImgUrl();
        anoPublicacao = entity.getAnoPublicacao();
        generoId = entity.getGenero().getId();
        editoraId = entity.getEditora().getId();
    }

}
