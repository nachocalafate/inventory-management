package com.calafate.inventory_management.repository;

import com.calafate.inventory_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    // útil para buscar por DNI, que debería ser único
    Optional<Customer> findByDni(String dni);
}