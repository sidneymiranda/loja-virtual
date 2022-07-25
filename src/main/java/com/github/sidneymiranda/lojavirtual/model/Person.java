package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_person", sequenceName = "seq_person", allocationSize = 1)
public abstract class Person implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    private Long id;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private String name;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private String email;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private String phone;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Address> addresses;
}
