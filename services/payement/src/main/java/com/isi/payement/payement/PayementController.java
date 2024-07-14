package com.isi.payement.payement;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payements")
public class PayementController {

    private final PayementService service ;

    @PostMapping
    public ResponseEntity<Integer> createPayement(
            @RequestBody @Valid PayementRequest request
    ){
        return ResponseEntity.ok(service.createPayement(request));
    }
}
