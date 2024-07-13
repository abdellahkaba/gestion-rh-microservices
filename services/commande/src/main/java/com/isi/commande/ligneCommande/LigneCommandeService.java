package com.isi.commande.ligneCommande;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LigneCommandeService {
    private final LigneCommandeRepository repository;
    private final LigneCommandeMapper mapper ;
    public Integer saveLigneCommande(LigneCommandeRequest request) {
        var commande = mapper.toCommande(request);
        return repository.save(commande).getId();
    }

    public List<LigneCommandeResponse> findAllByCommandeId(Integer commandeId) {
        return repository.findAllByCommandeId(commandeId)
                .stream()
                .map(mapper::toLigneCommandeResponse)
                .collect(Collectors.toList());
    }
}
