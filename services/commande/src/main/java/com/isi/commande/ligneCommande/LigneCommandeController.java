package com.isi.commande.ligneCommande;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ligne-commandes")
@RequiredArgsConstructor
public class LigneCommandeController {
    private final LigneCommandeService service ;
    @GetMapping("/commande/{commande-id}")

    public ResponseEntity<List<LigneCommandeResponse>> findById(
            @PathVariable("commande-id") Integer commandeId
    ){
        return ResponseEntity.ok(service.findAllByCommandeId(commandeId));
    }
}
