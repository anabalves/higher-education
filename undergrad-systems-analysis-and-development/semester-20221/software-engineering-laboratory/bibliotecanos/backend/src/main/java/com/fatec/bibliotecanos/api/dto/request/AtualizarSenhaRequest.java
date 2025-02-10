package com.fatec.bibliotecanos.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AtualizarSenhaRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String senha;
}
