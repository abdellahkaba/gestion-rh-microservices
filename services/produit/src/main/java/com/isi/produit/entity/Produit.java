package com.isi.produit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Produit {

    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String description;
    private double quantite;
    private BigDecimal prix;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
