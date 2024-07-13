package com.isi.commande.kafka;

import com.isi.commande.client.ClientResponse;
import com.isi.commande.payement.PayementMethode;
import com.isi.commande.produit.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record CommandeConfirmation(
        String commandeRef,
        BigDecimal montantTotal,
        PayementMethode payementMethode,
        ClientResponse clientResponse,
        List<PurchaseResponse> produits
) {
}
