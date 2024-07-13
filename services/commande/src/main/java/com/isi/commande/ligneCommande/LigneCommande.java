package com.isi.commande.ligneCommande;

import com.isi.commande.commande.Commande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class LigneCommande {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
    private Integer produitId;
    private double quantite;
}
