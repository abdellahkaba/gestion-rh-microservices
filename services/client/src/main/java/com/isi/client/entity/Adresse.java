package com.isi.client.entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Adresse {

    private String rue;
    private String numeroMaison;
    private String codePostal;
}
