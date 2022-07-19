package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
@SequenceGenerator(name = "seq_orders", sequenceName = "seq_orders", allocationSize = 1)
public class Order implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orders")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "delivery_address_fk"))
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "billing_address_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "billing_address_fk"))
    private Address billingAddress;

    private BigDecimal amount;

    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "payment_method_fk"))
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "sales_nf_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "sales_nf_fk"))
    private SalesNF salesNF;

    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "coupon_fk"))
    private Coupon coupon;

    private BigDecimal shipping;

    private Integer shippingDay;

    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @Temporal(TemporalType.DATE)
    private Date orderDate;
}
