package com.isi.payement.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated

public record Client(
        String id,

        @NotNull(message = "le prenom est requis")
        String prenom,

        @NotNull(message = "Le nom est requis")
        String nom,

        @NotNull(message = "Le nom est requis")
        @Email(message = "Veuillez saisir le formant Email")
        String email
) {
}
