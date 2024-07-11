package com.isi.employemicroservice.controller;
//
//import com.isi.employemicroservice.entity.Employe;
//import com.isi.employemicroservice.service.EmployeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/employes")
//public class EmployeController {
//
//    @Autowired
//    private EmployeService employeService;
//
//    @GetMapping
//    public ResponseEntity<?> getAllEmployes() {
//        List<Employe> employes = employeService.getAllEmployes();
//        if (employes.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Il n'y a pas d'employés pour le moment.");
//        }
//        return ResponseEntity.ok(employes);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getEmployeById(@PathVariable int id) {
//        Optional<Employe> employe = employeService.getEmployeById(id);
//        if (employe.isPresent()) {
//            return ResponseEntity.ok(employe.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veuillez vérifier, l'employé avec cet ID n'existe pas.");
//        }
//    }
//
//    @GetMapping("/nom/{nom}")
//    public ResponseEntity<?> getEmployeByNom(@PathVariable String nom) {
//        Optional<Employe> employe = employeService.getEmployeByName(nom);
//        if (employe.isPresent()) {
//            return ResponseEntity.ok(employe.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'employé avec ce nom n'existe pas.");
//        }
//    }
//
//    @GetMapping("/email/{email}")
//    public ResponseEntity<?> getEmployeByEmail(@PathVariable String email) {
//        Optional<Employe> employe = employeService.getEmployeByEmail(email);
//        if (employe.isPresent()) {
//            return ResponseEntity.ok(employe.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'employé avec cet email n'existe pas.");
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<?> createEmploye(@RequestBody Employe employe) {
//        try {
//            Employe createdEmploye = employeService.addEmploye(employe);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Employé créé avec succès : " + createdEmploye.getNom() + "|" + createdEmploye.getPrenom() + "|" + createdEmploye.getEmail() + "|" + createdEmploye.getTelephone() + "|" +createdEmploye.getAdresse() );
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateEmploye(@PathVariable int id, @RequestBody Employe employe) {
//        try {
//            Employe updatedEmploye = employeService.uodateEmploye(id, employe);
//            return ResponseEntity.ok().body("Employé mis à jour avec succès : " + updatedEmploye);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteEmploye(@PathVariable int id) {
//        try {
//            employeService.deleteEmploye(id);
//            return ResponseEntity.ok().body("Employé supprimé avec succès.");
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }
//}


import com.isi.employemicroservice.entity.Employe;
import com.isi.employemicroservice.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employes")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        if (employes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Il n'y a pas d'employés pour le moment.");
        }
        return ResponseEntity.ok(employes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeById(@PathVariable int id) {
        Optional<Employe> employe = employeService.getEmployeById(id);
        if (employe.isPresent()) {
            return ResponseEntity.ok(employe.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veuillez vérifier, l'employé avec cet ID n'existe pas.");
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<?> getEmployeByNom(@PathVariable String nom) {
        Optional<Employe> employe = employeService.getEmployeByName(nom);
        if (employe.isPresent()) {
            return ResponseEntity.ok(employe.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'employé avec ce nom n'existe pas.");
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getEmployeByEmail(@PathVariable String email) {
        Optional<Employe> employe = employeService.getEmployeByEmail(email);
        if (employe.isPresent()) {
            return ResponseEntity.ok(employe.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'employé avec cet email n'existe pas.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createEmploye(@RequestBody Employe employe) {
        try {
            Employe createdEmploye = employeService.addEmploye(employe);
           return ResponseEntity.status(HttpStatus.CREATED).body("Employé créé avec succès : " +
                   createdEmploye.getNom() + "|" + createdEmploye.getPrenom()
                   + "|" + createdEmploye.getEmail() + "|"
                   + createdEmploye.getTelephone() + "|" +createdEmploye.getAdresse() );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmploye(@PathVariable int id, @RequestBody Employe employe) {
        try {
            Employe updatedEmploye = employeService.updateEmploye(id, employe);
            return ResponseEntity.ok("Employe Update success" +" ID:" + id  + " Email:" + updatedEmploye.getEmail());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmploye(@PathVariable int id) {
        try {
            employeService.deleteEmploye(id);
            return ResponseEntity.ok("Employé supprimé avec succès." + "ID:" + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}


