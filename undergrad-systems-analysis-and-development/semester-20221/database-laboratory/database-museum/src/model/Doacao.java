package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Doacao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeInstituicao;
    private String cnpj;
    private Double valorDoado;
    private LocalDate dataDoacao;
    private String descricao;

    public Doacao() {
    }

    public Doacao(Long id, String nomeInstituicao, String cnpj, Double valorDoado, LocalDate dataDoacao, String descricao) {
        setId(id);
        setNomeInstituicao(nomeInstituicao);
        setCnpj(cnpj);
        setValorDoado(valorDoado);
        setDataDoacao(dataDoacao);
        setDescricao(descricao);
    }

    public Doacao(String nomeInstituicao, String cnpj, Double valorDoado, LocalDate dataDoacao, String descricao) {
        setNomeInstituicao(nomeInstituicao);
        setCnpj(cnpj);
        setValorDoado(valorDoado);
        setDataDoacao(dataDoacao);
        setDescricao(descricao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getValorDoado() {
        return valorDoado;
    }

    public void setValorDoado(Double valorDoado) {
        this.valorDoado = valorDoado;
    }

    public LocalDate getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(LocalDate dataDoacao) {
        this.dataDoacao = dataDoacao;
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
        if (!(o instanceof Doacao)) return false;
        Doacao doacao = (Doacao) o;
        return Objects.equals(getId(), doacao.getId()) && Objects.equals(getNomeInstituicao(), doacao.getNomeInstituicao()) && Objects.equals(getCnpj(), doacao.getCnpj()) && Objects.equals(getValorDoado(), doacao.getValorDoado()) && Objects.equals(getDataDoacao(), doacao.getDataDoacao()) && Objects.equals(getDescricao(), doacao.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeInstituicao(), getCnpj(), getValorDoado(), getDataDoacao(), getDescricao());
    }

}
