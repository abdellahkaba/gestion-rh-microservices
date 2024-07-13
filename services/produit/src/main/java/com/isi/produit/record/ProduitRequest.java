package com.isi.produit.record;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProduitRequest(
       Integer id,

       @NotNull(message = "Veuillez donner le nom du produit")
       String nom,

       @NotNull(message = "Veuillez donner la description du produit")
       String description,

       @Positive(message = "la quantite doit etre positive")
       double quantite,

       @Positive(message = "le prix doit etre positif")
       BigDecimal prix,
       @NotNull(message = "Veuillez donner la categorie du produit")
       Integer categorieId

) {
}
