package com.isi.commande.commande;


import com.isi.commande.client.ClientRestClient;
import com.isi.commande.exception.BusinessException;
import com.isi.commande.ligneCommande.LigneCommandeRequest;
import com.isi.commande.ligneCommande.LigneCommandeService;
import com.isi.commande.produit.ProduitClient;
import com.isi.commande.produit.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final ClientRestClient restClient;
    private final ProduitClient produitClient;
    private final CommandeRepository repository;
    private final CommandeMapper mapper;
    private final LigneCommandeService ligneCommandeService;
    public Integer createCommande(CommandeRequest request) {
        //verifier le client -->OpenFeign

        var client = this.restClient.findClientById(request.clientId())
                .orElseThrow(() -> new BusinessException("Impossible de creer la commande:: pas de client"));
        //verifier le produit ---> produit-ms(RestTemplate)
        this.produitClient.purchaseProduits(request.produits());
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
        return null;
    }
}
