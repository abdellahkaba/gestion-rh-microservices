package com.isi.produit.record;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProduitResponse(
        Integer id,
        String nom,
        String description,
        double quantite,
        BigDecimal prix,
        Integer categorieId,
        String categorieNom,
        String categorieDescription
) {
}
