package com.fatec.bibliotecanos.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SignupRequest {

    @NotBlank
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String cep;
    private String endereco;
    private String numeroEndereco;
    private String cidade;
    private String estado;

    @NotBlank
    @Email
    private String email;
    private String emailAlternativo;

    @NotBlank
    private String senha;

    private Set<String> roles;
    private String complemento;

}
