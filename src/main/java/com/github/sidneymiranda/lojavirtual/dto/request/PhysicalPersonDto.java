package com.github.sidneymiranda.lojavirtual.dto.request;

import com.github.sidneymiranda.lojavirtual.validators.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class PhysicalPersonDto extends PersonDto {

    @NotBlank(message = "must not be blank")
    private String cpf;

    @Date
    @NotBlank(message = "must not be blank")
    private String dob;
}
