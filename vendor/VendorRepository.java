package com.contractwatch.vendor.repository;

import com.contractwatch.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}