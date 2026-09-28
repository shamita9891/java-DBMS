package com.example.contractwatch1.contract;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract addContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Optional<Contract> getContractById(Long id) {
        return contractRepository.findById(id);
    }

    public Contract updateContract(Long id, Contract contract) {

        Optional<Contract> existing =
                contractRepository.findById(id);

        if (existing.isPresent()) {

            Contract oldContract = existing.get();

            oldContract.setContractName(contract.getContractName());
            oldContract.setContractNumber(contract.getContractNumber());
            oldContract.setStartDate(contract.getStartDate());
            oldContract.setExpiryDate(contract.getExpiryDate());
            oldContract.setStatus(contract.getStatus());
            oldContract.setDescription(contract.getDescription());
            oldContract.setVendor(contract.getVendor());

            return contractRepository.save(oldContract);
        }

        return null;
    }

    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }
}