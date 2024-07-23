package com.isi.employe.employe;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final EmployeService service ;
    @PostMapping
    public ResponseEntity<String> createEmploye(
            @RequestBody @Valid EmployeRequest request){
        return ResponseEntity.ok(service.createEmploye(request));
    }

}
