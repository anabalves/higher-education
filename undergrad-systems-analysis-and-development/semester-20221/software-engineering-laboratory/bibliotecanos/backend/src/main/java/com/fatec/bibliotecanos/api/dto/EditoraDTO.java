package com.fatec.bibliotecanos.api.dto;

import com.fatec.bibliotecanos.domain.model.Editora;
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
public class EditoraDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    public EditoraDTO(Editora entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

}
