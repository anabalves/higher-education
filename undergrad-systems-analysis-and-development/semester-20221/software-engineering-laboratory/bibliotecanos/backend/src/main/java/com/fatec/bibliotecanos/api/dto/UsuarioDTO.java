package com.fatec.bibliotecanos.api.dto;

import com.fatec.bibliotecanos.domain.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String cep;
    private String endereco;
    private String numeroEndereco;
    private String complemento;
    private String cidade;
    private String estado;

    @NotBlank
    @Email
    private String email;
    private String emailAlternativo;

    Set<RoleDTO> roles = new HashSet<>();

    private String situacao;
    private String observacao;

    public UsuarioDTO(Usuario entity) {
        id = entity.getId();
        nome = entity.getNome();
        sobrenome = entity.getSobrenome();
        cpf = entity.getCpf();
        telefone = entity.getTelefone();
        cep = entity.getCep();
        endereco = entity.getEndereco();
        numeroEndereco = entity.getNumeroEndereco();
        complemento = entity.getComplemento();
        cidade = entity.getCidade();
        estado = entity.getEstado();
        email = entity.getEmail();
        emailAlternativo = entity.getEmailAlternativo();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
        situacao = entity.getSituacao().name();
        observacao = entity.getObservacao();
    }

}
