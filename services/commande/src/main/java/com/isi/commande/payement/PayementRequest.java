package com.isi.commande.payement;

import com.isi.commande.client.ClientResponse;

import java.math.BigDecimal;

public record PayementRequest(
        BigDecimal montant,
        PayementMethode payementMethode,
        Integer commandeId,
        String commandeRef,
        ClientResponse client
) {
}
