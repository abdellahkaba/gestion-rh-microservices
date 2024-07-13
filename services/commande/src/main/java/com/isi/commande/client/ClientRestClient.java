package com.isi.commande.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "client-service",
        url = "${application.config.client-url}"
)
public interface ClientRestClient {
    @GetMapping("/{client-id}")
    Optional<ClientResponse> findClientById(
            @PathVariable("client-id") String clientId
    );
}
