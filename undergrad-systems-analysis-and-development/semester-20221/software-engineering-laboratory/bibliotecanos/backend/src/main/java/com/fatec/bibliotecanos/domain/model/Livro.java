package com.fatec.bibliotecanos.domain.model;

import com.fatec.bibliotecanos.domain.model.enums.ELivro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_livro")
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String autor;
    private Integer edicao;
    private String isbn;
    private Integer quantidade;
    private String imgUrl;
    private LocalDate anoPublicacao;

    @Enumerated(EnumType.STRING)
    private ELivro status;
    
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

}
