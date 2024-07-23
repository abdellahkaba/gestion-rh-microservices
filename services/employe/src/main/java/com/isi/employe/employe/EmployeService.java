package com.isi.employe.employe;


import com.isi.employe.exception.EmailConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeService {

    private final EmployeRepository repository;
    private final EmployeMapper mapper ;
    public String createEmploye(EmployeRequest request) {
        if (repository.findByEmail(request.email()).isPresent()){
           throw new EmailConflictException("L'email existe deja !");
        }

        var employe = repository.save(mapper.toEmploye(request));
        return employe.getId();
    }
}
