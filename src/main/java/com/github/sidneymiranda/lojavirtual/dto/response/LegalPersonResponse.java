package com.github.sidneymiranda.lojavirtual.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class LegalPersonResponse extends PersonResponse {

    private String cnpj;

    private String stateRegistration;

    private String municipalRegistration;

    private String fantasyName;

    private String corporateName;

    private String category;
}
