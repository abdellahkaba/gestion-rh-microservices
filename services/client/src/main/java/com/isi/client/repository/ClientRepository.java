package com.isi.client.repository;

import com.isi.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findByEmail(String email);
}
