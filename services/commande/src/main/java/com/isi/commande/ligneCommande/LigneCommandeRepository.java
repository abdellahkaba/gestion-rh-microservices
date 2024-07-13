package com.isi.commande.ligneCommande;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Integer> {
    List<LigneCommande> findAllByCommandeId(Integer commandeId);
}
