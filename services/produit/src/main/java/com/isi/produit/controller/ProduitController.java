package com.isi.produit.controller;

import com.isi.produit.record.ProduitPurchaseRequest;
import com.isi.produit.record.ProduitPurchaseResponse;
import com.isi.produit.record.ProduitRequest;
import com.isi.produit.record.ProduitResponse;
import com.isi.produit.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService service ;

    @PostMapping
    public ResponseEntity<Integer> createProduit(
            @RequestBody @Valid ProduitRequest request
    ){
        return  ResponseEntity.ok(service.createProduit(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProduitPurchaseResponse>> purchaseProduits(
            @RequestBody List<ProduitPurchaseRequest> request
    ){
        return ResponseEntity.ok(service.purchaseProduits(request));
    }

    @GetMapping("/{produit-id}")
    public ResponseEntity<ProduitResponse> findById(
            @PathVariable("produit-id") Integer produitId
    ){
        return ResponseEntity.ok(service.findById(produitId));
    }

    @GetMapping
    public ResponseEntity<List<ProduitResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
