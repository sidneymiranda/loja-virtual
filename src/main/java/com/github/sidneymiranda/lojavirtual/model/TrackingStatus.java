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
@Table(name ="tracking_status")
@SequenceGenerator(name = "seq_tracking_status", sequenceName = "seq_tracking_status", allocationSize = 1)
public class TrackingStatus implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tracking_status")
    private Long id;

    private String distributionCenter;

    private String city;

    private String state;

    private String status;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "order_fk"))
    private Order order;

}
