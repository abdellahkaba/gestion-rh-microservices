package com.isi.payement.payement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayementRepository extends JpaRepository<Payement, Integer> {
}
