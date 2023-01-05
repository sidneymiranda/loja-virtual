package com.github.sidneymiranda.lojavirtual.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDTO {
    private String id;
    private String authority;
}
