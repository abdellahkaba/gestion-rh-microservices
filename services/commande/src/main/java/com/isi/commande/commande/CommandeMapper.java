package com.isi.commande.commande;


import org.springframework.stereotype.Service;

@Service
public class CommandeMapper {
    public Commande toCommande(CommandeRequest request) {
        return Commande.builder()
                .id(request.id())
                .clientId(request.clientId())
                .reference(request.reference())
                .total(request.total())
                .payementMethode(request.payementMethode())
                .build();
    }

    public CommandeResponse fromCommande(Commande commande) {
        return new CommandeResponse(
               commande.getId(),
                commande.getReference(),
                commande.getTotal(),
                commande.getPayementMethode(),
                commande.getClientId()
        );
    }
}