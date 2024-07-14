package com.isi.notification.kafka.payement;

import java.math.BigDecimal;

public record PayementConfirmation(
        String commandeRef,
        BigDecimal montant,
        PayementMethode payementMethode,
        String nomClient,
        String prenomClient,
        String emailClient
) {
}
