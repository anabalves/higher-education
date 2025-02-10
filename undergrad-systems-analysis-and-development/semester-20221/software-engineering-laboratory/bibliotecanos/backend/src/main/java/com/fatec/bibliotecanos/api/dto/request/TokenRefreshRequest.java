package com.fatec.bibliotecanos.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TokenRefreshRequest {

    @NotBlank
    private String refreshToken;

}
