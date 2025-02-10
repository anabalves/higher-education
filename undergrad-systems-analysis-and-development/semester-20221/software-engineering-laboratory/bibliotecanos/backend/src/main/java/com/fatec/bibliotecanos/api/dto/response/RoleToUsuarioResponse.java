package com.fatec.bibliotecanos.api.dto.response;

import com.fatec.bibliotecanos.api.dto.RoleDTO;
import com.fatec.bibliotecanos.domain.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoleToUsuarioResponse {

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
    Set<RoleDTO> roles = new HashSet<>();
    private String situacao;
    private String observacao;

    public RoleToUsuarioResponse(Usuario entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.cpf = entity.getCpf();
        this.telefone = entity.getTelefone();
        this.email = entity.getEmail();
        this.emailAlternativo = entity.getEmailAlternativo();
        this.cep = entity.getCep();
        this.endereco = entity.getEndereco();
        this.numeroEndereco = entity.getNumeroEndereco();
        this.complemento = entity.getComplemento();
        this.cidade = entity.getCidade();
        this.estado = entity.getEstado();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
        this.situacao = entity.getSituacao().name();
        this.observacao = entity.getObservacao();
    }
}
