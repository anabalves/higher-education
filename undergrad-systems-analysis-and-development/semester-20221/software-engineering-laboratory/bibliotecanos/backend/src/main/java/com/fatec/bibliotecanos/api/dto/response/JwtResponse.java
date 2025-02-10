package com.fatec.bibliotecanos.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String email;
    private String emailAlternativo;
    private String cep;
    private String endereco;
    private String numeroEndereco;
    private String complemento;
    private String cidade;
    private String estado;
    private List<String> roles;
    private String situacao;
    private String observacao;

    public JwtResponse(String accessToken, String refreshToken, Long id, String nome, String sobrenome, String email, String emailAlternativo, String cpf, String telefone, String cep, String endereco, String numeroEndereco, String complemento, String cidade, String estado, List<String> roles, String situacao, String observacao) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.emailAlternativo = emailAlternativo;
        this.cep = cep;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.roles = roles;
        this.situacao = situacao;
        this.observacao = observacao;
    }

}
