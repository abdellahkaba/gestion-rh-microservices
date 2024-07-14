package com.isi.payement.payement;


import org.springframework.stereotype.Service;

@Service
public class PayementMapper {
    public Payement toPayement(PayementRequest request) {
        return Payement.builder()
                .id(request.id())
                .montant(request.montant())
                .commandeId(request.commandeId())
                .payementMethode(request.payementMethode())
                .build();
    }
}
