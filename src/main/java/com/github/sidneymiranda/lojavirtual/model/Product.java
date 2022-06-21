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
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
public class Product implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    @Column(name = "id", nullable = false)
    private Long id;

    private String unitType;

    @Column(columnDefinition = "text")
    private String name;

    private String description;

//     NotaItemProduto - falta criar
     private Double weight;
     private Double height;
     private Double width;
     private Double depth;
     private BigDecimal saleValue = BigDecimal.ZERO;
     private Integer quantity = 0;
     private Boolean stockAlert = Boolean.FALSE;
     private Integer stockAlertQuantity;
     private Integer numberClicks;
     private String youtubeLink;

}
