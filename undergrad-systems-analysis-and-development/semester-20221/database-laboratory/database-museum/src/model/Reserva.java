package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Integer quantidadePessoas;
    private LocalDate dataReserva;
    private String horaInicio;

    public Reserva() {
    }

    public Reserva(Long id, String nome, String cpf, String contato, Integer quantidadePessoas, LocalDate dataReserva, String horaInicio) {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setTelefone(contato);
        setQuantidadePessoas(quantidadePessoas);
        setDataReserva(dataReserva);
        setHoraInicio(horaInicio);
    }

    public Reserva(String nome, String cpf, String contato, Integer quantidadePessoas, LocalDate dataReserva, String horaInicio) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(contato);
        setQuantidadePessoas(quantidadePessoas);
        setDataReserva(dataReserva);
        setHoraInicio(horaInicio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(getId(), reserva.getId()) && Objects.equals(getNome(), reserva.getNome()) && Objects.equals(getCpf(), reserva.getCpf()) && Objects.equals(getTelefone(), reserva.getTelefone()) && Objects.equals(getQuantidadePessoas(), reserva.getQuantidadePessoas()) && Objects.equals(getDataReserva(), reserva.getDataReserva()) && Objects.equals(getHoraInicio(), reserva.getHoraInicio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getTelefone(), getQuantidadePessoas(), getDataReserva(), getHoraInicio());
    }

}
