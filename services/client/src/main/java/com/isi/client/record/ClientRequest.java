package com.isi.client.record;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ClientRequest(
         String id,
         @NotNull(message = "Veuillez saisir le prenom")
         String prenom,
         @NotNull(message = "Veuillez saisir le nom")

         String nom,
         @NotNull(message = "Veuillez saisir l'email")
      //   @Column(unique = true)
         @Email(message = "le mail n'est pas valide")
         String email,

         @NotNull(message = "Veuillez saisir l'adresse")
         String adresse
) {
}
