package com.isi.produit.record;

import jakarta.validation.constraints.NotNull;

public record ProduitPurchaseRequest(

        @NotNull(message = "Produit non")
        Integer produitId,

        @NotNull(message = "Quantite non")
        double quantite
) {
}
