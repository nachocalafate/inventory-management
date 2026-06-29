package com.calafate.inventory_management.repository;

import com.calafate.inventory_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    // útil para buscar por código de producto
    Optional<Product> findByCode(String code);
    // útil para listar solo productos activos
    List<Product> findByActiveTrue();
}