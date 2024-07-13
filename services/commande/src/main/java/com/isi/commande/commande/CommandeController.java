package com.isi.commande.commande;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
