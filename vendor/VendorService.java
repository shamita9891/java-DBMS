package com.contractwatch.vendor.service;

import com.contractwatch.vendor.entity.Vendor;
import com.contractwatch.vendor.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    public Vendor updateVendor(Long id, Vendor vendor) {

        Optional<Vendor> existing = vendorRepository.findById(id);

        if (existing.isPresent()) {

            Vendor oldVendor = existing.get();

            oldVendor.setVendorName(vendor.getVendorName());
            oldVendor.setCompanyName(vendor.getCompanyName());
            oldVendor.setEmail(vendor.getEmail());
            oldVendor.setPhone(vendor.getPhone());
            oldVendor.setAddress(vendor.getAddress());

            return vendorRepository.save(oldVendor);
        }

        return null;
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}