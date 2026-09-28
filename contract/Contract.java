package com.example.contractwatch1.contract;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractName;

    private String contractNumber;

    private LocalDate startDate;

    private LocalDate expiryDate;

    private String status;

    private String description;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private com.contractwatch.vendor.entity.Vendor vendor;
}