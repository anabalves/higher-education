package com.fatec.bibliotecanos.domain.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.bibliotecanos.domain.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDetailsImpl implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private String email;
    private String emailAlternativo;
    private String cep;
    private String endereco;
    private String numeroEndereco;
    private String complemento;
    private String cidade;
    private String estado;

    @JsonIgnore
    private String senha;

    private Collection<? extends GrantedAuthority> authorities;

    private String situacao;
    private String observacao;

    public static UsuarioDetailsImpl build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAutorizacao().name()))
                .collect(Collectors.toList());

        return new UsuarioDetailsImpl(
            usuario.getId(),
            usuario.getNome(),
            usuario.getSobrenome(),
            usuario.getCpf(),
            usuario.getTelefone(),
            usuario.getEmail(),
            usuario.getEmailAlternativo(),
            usuario.getCep(),
            usuario.getEndereco(),
            usuario.getNumeroEndereco(),
            usuario.getComplemento(),
            usuario.getCidade(),
            usuario.getEstado(),
            usuario.getSenha(),
            authorities,
            usuario.getSituacao().name(),
            usuario.getObservacao());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsuarioDetailsImpl usuarioDetails = (UsuarioDetailsImpl) o;
        return Objects.equals(id, usuarioDetails.id);
    }

}