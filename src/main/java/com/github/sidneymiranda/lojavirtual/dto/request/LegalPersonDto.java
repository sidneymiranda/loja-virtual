package com.github.sidneymiranda.lojavirtual.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LegalPersonDto extends PersonDto {

    private String cnpj;

    private String stateRegistration;

    private String municipalRegistration;

    private String fantasyName;

    private String corporateName;

    private String category;
}
