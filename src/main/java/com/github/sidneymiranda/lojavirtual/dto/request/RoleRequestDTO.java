package com.github.sidneymiranda.lojavirtual.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestDTO {

    @NotBlank(message = "Campo authority é obrigatório.")
    private String authority;
}
