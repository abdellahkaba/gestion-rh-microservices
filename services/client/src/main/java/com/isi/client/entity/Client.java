package com.isi.client.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Document
public class Client {
    private String id;
    private String prenom;
    private String nom;
    private String email;
    private Adresse adresse;

}
