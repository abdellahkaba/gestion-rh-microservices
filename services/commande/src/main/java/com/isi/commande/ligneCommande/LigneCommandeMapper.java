package com.isi.commande.ligneCommande;

import com.isi.commande.commande.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class LigneCommandeMapper {
    public LigneCommande toCommande(LigneCommandeRequest request) {
        return LigneCommande.builder()
                .id(request.id())
                .quantite(request.quantite())
                .commande(
                        Commande.builder()
                                .id(request.commandeId())
                                .build()
                )
                .produitId(request.produitId())
                .build();
    }
}
