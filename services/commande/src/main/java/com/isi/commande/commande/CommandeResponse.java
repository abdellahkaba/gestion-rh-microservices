package com.isi.commande.commande;

import com.isi.commande.payement.PayementMethode;

import java.math.BigDecimal;

public record CommandeResponse(
    Integer id,
    String reference,
    BigDecimal total,
    PayementMethode payementMethode,
    String clientId
) {
}
