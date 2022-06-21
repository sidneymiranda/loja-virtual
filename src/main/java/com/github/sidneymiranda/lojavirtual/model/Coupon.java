package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "seq_coupon", sequenceName = "seq_coupon", allocationSize = 1)
public class Coupon implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_coupon")
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

    private BigDecimal discountAmount;

    private BigDecimal discountPercentage;

    @Temporal(TemporalType.DATE)
    private Date couponValidity;

}
