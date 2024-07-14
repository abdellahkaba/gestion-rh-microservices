package com.isi.notification.kafka.commande;

public record Client(
        String id,
        String prenom,
        String nom,
        String email
) {
}
