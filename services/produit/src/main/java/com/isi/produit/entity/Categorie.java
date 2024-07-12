package com.isi.produit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Categorie {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String description;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.REMOVE)
    private List<Produit> produits ;
}
