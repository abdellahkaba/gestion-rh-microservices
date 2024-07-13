package com.isi.commande.ligneCommande;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LigneCommandeService {
    private final LigneCommandeRepository repository;
    private final LigneCommandeMapper mapper ;
    public Integer saveLigneCommande(LigneCommandeRequest request) {
        var commande = mapper.toCommande(request);
        return repository.save(commande).getId();
    }
}
