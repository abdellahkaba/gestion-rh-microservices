package com.isi.produit.repository;

import com.isi.produit.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {


    List<Produit> findAllByIdInOrderById(List<Integer> produitIds);

}
