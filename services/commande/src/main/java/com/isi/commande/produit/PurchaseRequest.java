package com.isi.commande.produit;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Le produit est obligatoire")
        Integer produitId,
        @Positive(message = "La quantité est obligatoire")
        double quantite
) {
}
