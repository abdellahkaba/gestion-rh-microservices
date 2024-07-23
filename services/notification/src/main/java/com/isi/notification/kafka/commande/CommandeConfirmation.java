package com.isi.notification.kafka.commande;

import com.isi.notification.kafka.payement.PayementMethode;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.math.BigDecimal;
import java.util.List;


public record CommandeConfirmation(
        String commandeRef,
        BigDecimal montantTotal,
        @Enumerated(EnumType.STRING) PayementMethode payementMethode,
        Client client,
        @ElementCollection List<Produit> produits
) {
}
