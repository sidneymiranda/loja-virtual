package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
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

    @Column(name = "state_registration")
    private String stateRegistration;

    @Column(name = "municipal_registration")
    private String municipalRegistration;

    @Column(name = "fantasy_name")
    private String fantasyName;

    @Column(name = "corporate_name")
    private String corporateName;

    private String category;
}
