package com.github.sidneymiranda.lojavirtual.model;

import com.github.sidneymiranda.lojavirtual.enums.ReceivableStatus;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "seq_receivable", sequenceName = "seq_receivable", allocationSize = 1)
public class Receivable implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_receivable")
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private ReceivableStatus status;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date payDate;

    private BigDecimal amount;

    private BigDecimal discountAmount;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    private Person person;

}
