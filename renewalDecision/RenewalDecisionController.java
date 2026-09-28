package com.example.contractwatch1.renewalDecision;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/renewal-decisions")
@CrossOrigin
public class RenewalDecisionController {

    private final RenewalDecisionService renewalDecisionService;

    public RenewalDecisionController(
            RenewalDecisionService renewalDecisionService) {

        this.renewalDecisionService = renewalDecisionService;
    }

    @PostMapping
    public RenewalDecision addDecision(
            @RequestBody RenewalDecision decision) {

        return renewalDecisionService.addDecision(decision);
    }

    @GetMapping
    public List<RenewalDecision> getAllDecisions() {

        return renewalDecisionService.getAllDecisions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RenewalDecision> getDecision(
            @PathVariable Long id) {

        return renewalDecisionService.getDecisionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RenewalDecision> updateDecision(
            @PathVariable Long id,
            @RequestBody RenewalDecision decision) {

        RenewalDecision updated =
                renewalDecisionService.updateDecision(
                        id, decision
                );

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDecision(
            @PathVariable Long id) {

        renewalDecisionService.deleteDecision(id);

        return ResponseEntity.ok(
                "Renewal decision deleted successfully"
        );
    }
}