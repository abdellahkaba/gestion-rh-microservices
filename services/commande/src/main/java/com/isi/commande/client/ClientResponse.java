package com.isi.commande.client;

public record ClientResponse(

        String id,
        String prenom,
        String nom,
        String email
) {
}
