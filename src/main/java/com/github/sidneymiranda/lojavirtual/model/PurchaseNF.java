package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "purchase_nf")
@SequenceGenerator(name = "seq_purchase_nf", sequenceName = "seq_purchase_nf", allocationSize = 1, initialValue = 1)
public class PurchaseNF implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_purchase_nf")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private String number;

    @Column(nullable = false)
    private String series;
    private String observation;

    @Column(nullable = false)
    private BigDecimal amount;

    private BigDecimal discount;

    @Column(nullable = false)
    private BigDecimal icms;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date buyDate;

    @ManyToOne
    @JoinColumn(name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "bill_to_pay_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "bill_to_pay_fk"))
    private BillToPay billToPay;

}
