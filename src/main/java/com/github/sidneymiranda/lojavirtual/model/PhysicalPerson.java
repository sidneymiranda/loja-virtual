package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "physical_person")
public class PhysicalPerson extends Person {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cpf;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dob;
}
