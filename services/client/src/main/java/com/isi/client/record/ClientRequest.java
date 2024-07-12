package com.isi.client.record;

import com.isi.client.entity.Adresse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ClientRequest(
         String id,
         @NotNull(message = "Veuillez saisir le prenom")
         String prenom,
         @NotNull(message = "Veuillez saisir le nom")

         String nom,
         @NotNull(message = "Veuillez saisir l'email")
         @Email(message = "le mail n'est pas valide")
         String email,
         Adresse adresse
) {
}
