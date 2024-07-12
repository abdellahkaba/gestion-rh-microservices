package com.isi.client.mapper;


import com.isi.client.entity.Client;
import com.isi.client.record.ClientRequest;
import com.isi.client.record.ClientResponse;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public Client toClient(ClientRequest request) {
        if (request == null){
            return null ;
        }
        return Client.builder()
                .id(request.id())
                .prenom(request.prenom())
                .nom(request.nom())
                .email(request.email())
                .adresse(request.adresse())
                .build();
    }

    public ClientResponse fromClient(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getPrenom(),
                client.getNom(),
                client.getEmail(),
                client.getAdresse()
        );
    }
}
