package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Arte implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeObra;
    private String nomeArtista;
    private LocalDate dataCriacao;
    private String descricao;

    public Arte() {
    }

    public Arte(Long id, String nomeObra, String nomeArtista, LocalDate dataCriacao, String descricao) {
        setId(id);
        setNomeObra(nomeObra);
        setNomeArtista(nomeArtista);
        setDataCriacao(dataCriacao);
        setDescricao(descricao);
    }

    public Arte(String nomeObra, String nomeArtista, LocalDate dataCriacao, String descricao) {
        setNomeObra(nomeObra);
        setNomeArtista(nomeArtista);
        setDataCriacao(dataCriacao);
        setDescricao(descricao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeObra() {
        return nomeObra;
    }

    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arte)) return false;
        Arte arte = (Arte) o;
        return Objects.equals(getId(), arte.getId()) && Objects.equals(getNomeObra(), arte.getNomeObra()) && Objects.equals(getNomeArtista(), arte.getNomeArtista()) && Objects.equals(getDataCriacao(), arte.getDataCriacao()) && Objects.equals(getDescricao(), arte.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeObra(), getNomeArtista(), getDataCriacao(), getDescricao());
    }

}
