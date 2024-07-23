package com.isi.employe.employe;


import org.springframework.stereotype.Service;

@Service
public class EmployeMapper {


    public Employe toEmploye(EmployeRequest request) {
        if (request == null){
            return null ;
        }
        return Employe.builder()
                .id(request.id())
                .prenom(request.prenom())
                .nom(request.nom())
                .email(request.email())
                .adresse(request.adresse())
                .dateNaissance(request.dateNaissance())
                .tel(request.tel())
                .build();
    }
}
