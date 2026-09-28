package com.example.contractwatch1.renewalDecision;

import com.example.contractwatch1.contract.Contract;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "renewal_decisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RenewalDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String decision;

    private String reason;

    private LocalDate decisionDate;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}