package com.isi.payement.notification;

import com.isi.payement.payement.PayementMethode;

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
