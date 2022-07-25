package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "legal_person")
public class LegalPerson extends Person {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String stateRegistration;

    @Column(name = "municipal_registration")
    private String municipalRegistration;

    @Column(nullable = false)
    private String fantasyName;

    @Column(nullable = false)
    private String corporateName;

    private String category;
}
