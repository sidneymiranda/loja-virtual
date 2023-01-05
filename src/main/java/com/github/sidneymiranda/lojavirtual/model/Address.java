package com.github.sidneymiranda.lojavirtual.model;

import com.github.sidneymiranda.lojavirtual.enums.AddressType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "seq_address", sequenceName = "seq_address", allocationSize = 1)
public class Address implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String number;

    private String complement;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String city;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    private Person person;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
