package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "seq_sales_invoice", sequenceName = "seq_sales_invoice", allocationSize = 1)
public class SalesNF implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sales_invoice")
    private Long id;

    private String number;
    private String series;
    private String type;

//  utilizar algum padrão de projeto
    private String xml;
    private String pdf;
}
