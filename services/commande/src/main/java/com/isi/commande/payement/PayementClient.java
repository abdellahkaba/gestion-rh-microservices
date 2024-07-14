package com.isi.commande.payement;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "produit-service", url = "${application.config.payement-url}"
)
public interface PayementClient {
    @PostMapping
    Integer requestCommandePayement(@RequestBody PayementRequest request);
}
