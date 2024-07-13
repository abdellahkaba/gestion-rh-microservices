package com.isi.commande.produit;

import java.math.BigDecimal;

public record PurchaseResponse(
       Integer produitId,
       String nom,
       String description,
       double quantite,
       BigDecimal prix

) {
}
