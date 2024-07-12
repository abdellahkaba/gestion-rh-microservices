package com.isi.client.controller;


import com.isi.client.record.ClientRequest;
import com.isi.client.record.ClientResponse;
import com.isi.client.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service ;
    @PostMapping
    public ResponseEntity<String> createClient(
       @RequestBody @Valid ClientRequest request
    ){
        return ResponseEntity.ok(service.createClient(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateClient(
           @RequestBody @Valid ClientRequest request
    ){
        service.updateClient(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll(){
        return ResponseEntity.ok(service.findAllClient());
    }

    @GetMapping("/exists/{client-id}")
    public ResponseEntity<Boolean> existById(
            @PathVariable("client-id") String clientId
    ){
        return ResponseEntity.ok(service.existById(clientId));
    }


    @GetMapping("/{client-id}")
    public ResponseEntity<ClientResponse> findById(
            @PathVariable("client-id") String clientId
    ){
        return ResponseEntity.ok(service.findById(clientId));
    }

    @DeleteMapping("/{client-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("client-id") String clientId
    ){
        service.deleteClient(clientId);
        return ResponseEntity.accepted().build();
    }

}
