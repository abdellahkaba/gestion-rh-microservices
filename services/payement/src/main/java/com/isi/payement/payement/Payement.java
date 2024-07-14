package com.isi.payement.payement;


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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payement")
public class Payement {

    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal montant;
    @Enumerated(EnumType.STRING)
    private PayementMethode payementMethode;
    private Integer commandeId;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedDate;

}
