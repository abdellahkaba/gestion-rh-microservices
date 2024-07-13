package com.isi.produit.mapper;


import com.isi.produit.entity.Categorie;
import com.isi.produit.entity.Produit;
import com.isi.produit.record.ProduitPurchaseResponse;
import com.isi.produit.record.ProduitRequest;
import com.isi.produit.record.ProduitResponse;
import org.springframework.stereotype.Service;

@Service

public class ProduitMapper {
    public Produit toProduit(ProduitRequest request) {
        return Produit.builder()
                .id(request.id())
                .nom(request.nom())
                .description(request.description())
                .quantite(request.quantite())
                .prix(request.prix())
                .categorie(
                        Categorie.builder()
                                .id(request.categorieId())
                                .build())
                .build();
    }

    public ProduitResponse toProduitResponse(Produit produit) {
        return new ProduitResponse(
               produit.getId(),
                produit.getNom(),
                produit.getDescription(),
                produit.getQuantite(),
                produit.getPrix(),
                produit.getCategorie().getId(),
                produit.getCategorie().getNom(),
                produit.getCategorie().getDescription()

        );
    }

    public ProduitPurchaseResponse toProduitPurchaseResponse(Produit produit, double quantite) {
        return new ProduitPurchaseResponse(
                produit.getId(),
                produit.getNom(),
                produit.getDescription(),
                quantite,
                produit.getPrix()
        ) ;
    }
}
