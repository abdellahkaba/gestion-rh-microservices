package com.isi.client.record;

import com.isi.client.entity.Adresse;

public record ClientResponse(
       String id,
       String prenom,
       String nom,
       String email,
       Adresse adresse

) {


}
