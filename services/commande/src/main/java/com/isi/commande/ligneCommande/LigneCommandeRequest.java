package com.isi.commande.ligneCommande;

public record LigneCommandeRequest(
        Integer id,
        Integer commandeId,
        Integer produitId,
        double quantite) {
}
