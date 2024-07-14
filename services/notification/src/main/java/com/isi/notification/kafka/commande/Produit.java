package com.isi.notification.kafka.commande;

import java.math.BigDecimal;

public record Produit(
        Integer productId,
        String nom,
        String description,
        BigDecimal price,
        double quantite
) {
}
