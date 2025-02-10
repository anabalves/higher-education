package com.fatec.bibliotecanos.api.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LogOutRequest {

    private Long usuarioId;

}
