package com.isi.notification.kafka.commande;

import com.isi.notification.kafka.payement.PayementMethode;

import java.math.BigDecimal;
import java.util.List;

public record CommandeConfirmation(
        String commandeRef,
        BigDecimal montantTotal,
        PayementMethode payementMethode,
        Client client,
        List<Produit> produits
) {
}
