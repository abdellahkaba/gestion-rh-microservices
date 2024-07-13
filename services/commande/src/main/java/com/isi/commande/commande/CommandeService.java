package com.isi.commande.commande;


import com.isi.commande.client.ClientRestClient;
import com.isi.commande.exception.BusinessException;
import com.isi.commande.kafka.CommandeConfirmation;
import com.isi.commande.kafka.CommandeProducer;
import com.isi.commande.ligneCommande.LigneCommandeRequest;
import com.isi.commande.ligneCommande.LigneCommandeService;
import com.isi.commande.produit.ProduitClient;
import com.isi.commande.produit.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final ClientRestClient restClient;
    private final ProduitClient produitClient;
    private final CommandeRepository repository;
    private final CommandeMapper mapper;
    private final CommandeProducer producer;
    private final LigneCommandeService ligneCommandeService;
    public Integer createCommande(CommandeRequest request) {
        //verifier le client -->OpenFeign

        var client = this.restClient.findClientById(request.clientId())
                .orElseThrow(() -> new BusinessException("Impossible de creer la commande:: pas de client"));
        //verifier le produit ---> produit-ms(RestTemplate)
       var purchaseProduits =  this.produitClient.purchaseProduits(request.produits());
        //preciser la commande
        var commande = this.repository.save(mapper.toCommande(request));
        //preciser la ligne de commande

        for (PurchaseRequest purchaseRequest: request.produits()){
            ligneCommandeService.saveLigneCommande(
                    new LigneCommandeRequest(
                            null,
                            commande.getId(),
                            purchaseRequest.produitId(),
                            purchaseRequest.quantite()
                    )
            );
        }

        //commencer le processus de payement
        //envoie une confirmation de la commande ---> notification-ms(kafka)
        producer.sendCommandeComfirmation(
                new CommandeConfirmation(
                        request.reference(),
                        request.total(),
                        request.payementMethode(),
                        client,
                        purchaseProduits
                )
        );
        return commande.getId();
    }

    public List<CommandeResponse> findAll() {
            return repository.findAll()
                    .stream()
                    .map(mapper::fromCommande)
                    .collect(Collectors.toList());
    }

    public CommandeResponse findById(Integer commandeId) {
        return repository.findById(commandeId)
                .map(mapper::fromCommande)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Aucune commande trouve")));
    }
}
