package com.fatec.bibliotecanos.api.dto;

import com.fatec.bibliotecanos.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String autorizacao;

    public RoleDTO(Role role) {
        super();
        id = role.getId();
        autorizacao = role.getAutorizacao().name();
    }

}
