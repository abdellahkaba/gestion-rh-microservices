package com.isi.commande.commande;

import com.isi.commande.payement.PayementMethode;
import com.isi.commande.produit.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record CommandeRequest(
    Integer id ,
    String reference,

    @Positive(message = "Le montant doit etre positif")
    BigDecimal total,
    @NotNull(message = "La methode du payement doit etre precise")
    PayementMethode payementMethode,

    @NotNull(message = "Il faut un client pour faire la commande" )
    @NotEmpty(message = "Il faut un client pour faire la commande")
    @NotBlank(message = "Il faut un client pour faire la commande")
    String clientId,

    @NotEmpty(message = "Vous devriez au moins acheter le produit")
    List<PurchaseRequest> produits

)
{

}
