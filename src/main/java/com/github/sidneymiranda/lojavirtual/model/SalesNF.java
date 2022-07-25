package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "sales_nf")
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

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String type;

    @Column(columnDefinition = "text", nullable = false)
    private String xml;

    @Column(columnDefinition = "text", nullable = false)
    private String pdf;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "order_fk"))
    private Order order;
}
