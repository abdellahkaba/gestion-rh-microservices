package com.isi.payement.payement;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayementService {

    private final PayementRepository repository;
    private final PayementMapper mapper;

    public Integer createPayement(PayementRequest request) {
        var payement = repository.save(mapper.toPayement(request));
        return null;
    }
}
