package com.isi.client.service;



import com.isi.client.entity.Client;
import com.isi.client.exception.ClientNotFoundException;
import com.isi.client.exception.EmailConflictException;
import com.isi.client.mapper.ClientMapper;
import com.isi.client.record.ClientRequest;
import com.isi.client.record.ClientResponse;
import com.isi.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public String createClient(ClientRequest request) {
        if (repository.findByEmail(request.email()).isPresent()) {
            throw new EmailConflictException("L'email existe déjà.");
        }
        var client = repository.save(mapper.toClient(request));
        return client.getId();
    }

    public void updateClient(ClientRequest request) {
        var client = repository.findById(request.id())
                .orElseThrow(() -> new ClientNotFoundException(
                        String.format("Impossible de modifier le client:: Non trouvé ID:: %s", request.id())
                ));
        mergerClient(client, request);
        repository.save(client);
    }

    private void mergerClient(Client client, ClientRequest request) {
        if (StringUtils.isNotBlank(request.email()) &&
                !request.email().equals(client.getEmail()) &&
                repository.findByEmail(request.email()).isPresent()) {
            throw new EmailConflictException("L'email existe déjà.");
        }
        if (StringUtils.isNotBlank(request.prenom())){
            client.setPrenom(request.prenom());
        }
        if (StringUtils.isNotBlank(request.nom())){
            client.setNom(request.nom());
        }
        if (StringUtils.isNotBlank(request.email())){
            client.setEmail(request.email());
        }

        if(StringUtils.isNotBlank(request.adresse())) {
            client.setAdresse(request.adresse());
        }
    }

    public List<ClientResponse> findAllClient() {
        return repository.findAll()
                .stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    public Boolean existById(String clientId) {
        return repository.findById(clientId)
                .isPresent();
    }

    public ClientResponse findById(String clientId) {
        return repository.findById(clientId)
                .map(mapper::fromClient)
                .orElseThrow(() -> new ClientNotFoundException(String.format("Le client  non Trouvé ID::", clientId )));
    }

    public void deleteClient(String clientId) {
        repository.deleteById(clientId);
    }
}
