package com.isi.payement.payement;

import com.isi.payement.client.Client;

import java.math.BigDecimal;

public record PayementRequest(
        Integer id,
        BigDecimal montant,
        PayementMethode payementMethode,
        Integer commandeId,
        String commandeRef,
        Client client

) {
}
