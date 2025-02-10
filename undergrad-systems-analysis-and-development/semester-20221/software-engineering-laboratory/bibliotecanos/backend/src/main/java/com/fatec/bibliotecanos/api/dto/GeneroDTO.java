package com.fatec.bibliotecanos.api.dto;

import com.fatec.bibliotecanos.domain.model.Genero;
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
public class GeneroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    public GeneroDTO(Genero entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

}
