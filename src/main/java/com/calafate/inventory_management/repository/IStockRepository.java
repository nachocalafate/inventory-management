package com.calafate.inventory_management.repository;

import com.calafate.inventory_management.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {
    // buscar el stock de un producto en una sucursal específica
    Optional<Stock> findByProductIdAndBranchId(Long productId, Long branchId);
    // listar todo el stock de una sucursal
    List<Stock> findByBranchId(Long branchId);
    // listar el stock de un producto en todas las sucursales
    List<Stock> findByProductId(Long productId);
}