package com.fatec.bibliotecanos.domain.model;

import com.fatec.bibliotecanos.domain.model.enums.EReservaEmprestimoDevolucao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_emprestimo_devolucao")
public class ReservaEmprestimoDevolucao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EReservaEmprestimoDevolucao situacao;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public ReservaEmprestimoDevolucao() { }

    public ReservaEmprestimoDevolucao(ReservaEmprestimoDevolucao entity) {
        this.id = entity.getId();
        this.usuario = entity.getUsuario();
        this.livro = entity.getLivro();
        this.situacao = entity.getSituacao();
        this.dataDevolucao = entity.getDataDevolucao();
        this.dataEmprestimo = entity.getDataEmprestimo();
    }
}
