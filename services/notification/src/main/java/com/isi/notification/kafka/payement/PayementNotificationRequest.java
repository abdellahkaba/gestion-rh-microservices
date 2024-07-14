package com.isi.notification.kafka.payement;

import com.isi.notification.kafka.payement.PayementMethode;

import java.math.BigDecimal;

public record PayementNotificationRequest(
        String commandeRef,
        BigDecimal montant,
        PayementMethode payementMethode,
        String clientPrenom,
        String clientNom,
        String clientEmail
) {
}
