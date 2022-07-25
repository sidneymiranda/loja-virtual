package com.github.sidneymiranda.lojavirtual.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(nullable = false)
    private String unitType;

    @Column(nullable = false)
    private String name;

    private Boolean active = Boolean.TRUE;

    @Column(columnDefinition = "text", length = 2000, nullable = false)
    private String description;

//     NotaItemProduto - falta criar

     @Column(nullable = false)
     private Double weight;

     @Column(nullable = false)
     private Double height;

     @Column(nullable = false)
     private Double width;

     @Column(nullable = false)
     private Double depth;

     @Column(nullable = false)
     private BigDecimal saleValue;

     @Column(nullable = false)
     private Integer quantity = 0;

     private Boolean stockAlert = Boolean.FALSE;

     private Integer stockAlertQuantity = 0;

     private Integer numberClicks;

     private String youtubeLink;

}
