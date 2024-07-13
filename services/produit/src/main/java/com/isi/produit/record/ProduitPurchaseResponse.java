package com.isi.produit.record;

import java.math.BigDecimal;

public record ProduitPurchaseResponse(
    Integer produitId,
    String nom,
    String description,
    double quantite,
    BigDecimal prix

) {
}
