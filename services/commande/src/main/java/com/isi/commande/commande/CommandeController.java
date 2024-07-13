package com.isi.commande.commande;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commandes")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService service ;

    @PostMapping
    public ResponseEntity<Integer> createCommande(
            @RequestBody @Valid CommandeRequest request
    ){
        return ResponseEntity.ok(service.createCommande(request));
    }

    @GetMapping
    public ResponseEntity<List<CommandeResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{commande-id}")
    public ResponseEntity<CommandeResponse> findById(
           @PathVariable("commande-id") Integer commandeId
    ){
        return ResponseEntity.ok(service.findById(commandeId));
    }
}
