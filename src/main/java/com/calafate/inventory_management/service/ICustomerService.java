package com.calafate.inventory_management.service;

import com.calafate.inventory_management.dto.customer.CustomerRequestDTO;
import com.calafate.inventory_management.dto.customer.CustomerResponseDTO;

import java.util.List;

// ICustomerService.java
public interface ICustomerService {
    CustomerResponseDTO create(CustomerRequestDTO request);
    CustomerResponseDTO getById(Long id);
    List<CustomerResponseDTO> getAll();
    CustomerResponseDTO update(Long id, CustomerRequestDTO request);
    void delete(Long id);
    CustomerResponseDTO deactivate(Long id);
    CustomerResponseDTO getByDni(String dni);
}