package com.example.contractwatch1.renewalDecision;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenewalDecisionService {

    private final RenewalDecisionRepository renewalDecisionRepository;

    public RenewalDecisionService(
            RenewalDecisionRepository renewalDecisionRepository) {

        this.renewalDecisionRepository = renewalDecisionRepository;
    }

    public RenewalDecision addDecision(
            RenewalDecision decision) {

        return renewalDecisionRepository.save(decision);
    }

    public List<RenewalDecision> getAllDecisions() {

        return renewalDecisionRepository.findAll();
    }

    public Optional<RenewalDecision> getDecisionById(Long id) {

        return renewalDecisionRepository.findById(id);
    }

    public RenewalDecision updateDecision(
            Long id,
            RenewalDecision decision) {

        Optional<RenewalDecision> existing =
                renewalDecisionRepository.findById(id);

        if (existing.isPresent()) {

            RenewalDecision oldDecision = existing.get();

            oldDecision.setDecision(decision.getDecision());
            oldDecision.setReason(decision.getReason());
            oldDecision.setDecisionDate(
                    decision.getDecisionDate()
            );
            oldDecision.setContract(
                    decision.getContract()
            );

            return renewalDecisionRepository.save(oldDecision);
        }

        return null;
    }

    public void deleteDecision(Long id) {

        renewalDecisionRepository.deleteById(id);
    }
}