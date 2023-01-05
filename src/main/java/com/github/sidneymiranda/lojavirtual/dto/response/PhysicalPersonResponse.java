package com.github.sidneymiranda.lojavirtual.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class PhysicalPersonResponse extends PersonResponse {

    private String cpf;

    private Date dob;
}
