package com.fatec.bibliotecanos.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoleToUsuarioRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Set<String> roles;

}
