package com.isi.commande.commande;

import com.isi.commande.ligneCommande.LigneCommande;
import com.isi.commande.payement.PayementMethode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "commande_client")
public class Commande {

    @Id
    @GeneratedValue
    private Integer id;
    private String reference;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private PayementMethode payementMethode;
    private String clientId ;
    @OneToMany(mappedBy = "order" )
    private List<LigneCommande> ligneCommandes;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedDate;

}
