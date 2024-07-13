package com.isi.produit.service;

import com.isi.produit.exception.ProduitPurchaseException;
import com.isi.produit.mapper.ProduitMapper;
import com.isi.produit.record.ProduitPurchaseRequest;
import com.isi.produit.record.ProduitPurchaseResponse;
import com.isi.produit.record.ProduitRequest;
import com.isi.produit.record.ProduitResponse;
import com.isi.produit.repository.ProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository repository ;
    private final ProduitMapper mapper ;

    public Integer createProduit(ProduitRequest request) {
        var produit = mapper.toProduit(request);
        return repository.save(produit).getId() ;
    }

    public List<ProduitPurchaseResponse> purchaseProduits(List<ProduitPurchaseRequest> request) {
        var produitIds = request
                .stream()
                .map(ProduitPurchaseRequest::produitId)
                .toList();
        var storedProduits = repository.findAllByIdInOrderById(produitIds);
        if (produitIds.size() != storedProduits.size()){
            throw new ProduitPurchaseException("Un ou plusieurs produit n'exite pas");
        }
        var storesRequest = request
                .stream()
                .sorted(Comparator.comparing(ProduitPurchaseRequest::produitId))
                .toList();
        var purchaseProduits = new ArrayList<ProduitPurchaseResponse>();
        for (int i=0; i< storedProduits.size(); i++){
            var produit = storedProduits.get(i);
            var produitRequest = storesRequest.get(i);
            if (produit.getQuantite() < produitRequest.quantite()){
                throw new ProduitPurchaseException("La quantite en stock pour le produit avec ID::"+produitIds);
            }
            var newQuantite = produit.getQuantite() - produitRequest.quantite();
            produit.setQuantite(newQuantite);
            repository.save(produit);
            purchaseProduits.add(mapper.toProduitPurchaseResponse(produit, produitRequest.quantite()));

        }
        return purchaseProduits;
    }

    public ProduitResponse findById(Integer produitId) {
        return repository.findById(produitId)
                .map(mapper::toProduitResponse)
                .orElseThrow(()-> new EntityNotFoundException("Produit non trouvé"));
    }

    public List<ProduitResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProduitResponse)
                .collect(Collectors.toList());
    }
}
