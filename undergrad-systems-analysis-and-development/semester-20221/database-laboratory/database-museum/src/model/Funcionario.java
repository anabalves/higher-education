package model;

import java.io.Serializable;
import java.util.Objects;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String cargo;
    private String turno;
    private String email;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, String telefone, String cargo, String turno, String email, String senha) {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setCargo(cargo);
        setTurno(turno);
        setEmail(email);
        setSenha(senha);
    }

    public Funcionario(String nome, String cpf, String telefone, String cargo, String turno, String email, String senha) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setCargo(cargo);
        setTurno(turno);
        setEmail(email);
        setSenha(senha);
    }

    public Funcionario(String email, String senha) {
        setEmail(email);
        setSenha(senha);
    }

    public Funcionario(String nome, String telefone, String cargo, String turno) {
        setNome(nome);
        setTelefone(telefone);
        setCargo(cargo);
        setTurno(turno);
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getTelefone(), that.getTelefone()) && Objects.equals(getCargo(), that.getCargo()) && Objects.equals(getTurno(), that.getTurno()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSenha(), that.getSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getTelefone(), getCargo(), getTurno(), getEmail(), getSenha());
    }

}
