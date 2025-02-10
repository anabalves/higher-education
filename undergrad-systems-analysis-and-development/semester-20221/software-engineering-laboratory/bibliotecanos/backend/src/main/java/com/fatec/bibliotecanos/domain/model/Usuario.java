package com.fatec.bibliotecanos.domain.model;

import com.fatec.bibliotecanos.domain.model.enums.EUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cpf"),
        @UniqueConstraint(columnNames = "email")
})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cep;
    private String endereco;
    private String numeroEndereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(unique = true)
    @Email(message = "Favor entrar um email válido")
    private String email;
    private String emailAlternativo;

    @NotBlank(message = "Campo obrigatório")
    @Column(unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private EUsuario situacao;

    private String observacao;

    public Usuario(String nome, String sobrenome, String cpf, String telefone, String cep, String endereco, String numeroEndereco, String complemento, String cidade, String estado, String emailAlternativo, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.emailAlternativo = emailAlternativo;
        this.email = email;
        this.senha = senha;
    }
}
