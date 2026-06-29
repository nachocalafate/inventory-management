package com.calafate.inventory_management.repository;

import com.calafate.inventory_management.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCustomerId(Long customerId);
    List<Sale> findByBranchId(Long branchId);
}