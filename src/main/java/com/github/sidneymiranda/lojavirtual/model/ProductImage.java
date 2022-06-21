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
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "product_image")
@SequenceGenerator(name = "seq_product_image", sequenceName = "seq_product_image", allocationSize = 1)
public class ProductImage implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_image")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(columnDefinition = "text")
    private String thumbnail;

    @Column(columnDefinition = "text")
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "product_fk"))
    private Product product;

}
