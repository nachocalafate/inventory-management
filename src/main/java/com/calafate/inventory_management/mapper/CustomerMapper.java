package com.calafate.inventory_management.mapper;

import com.calafate.inventory_management.dto.customer.CustomerRequestDTO;
import com.calafate.inventory_management.dto.customer.CustomerResponseDTO;
import com.calafate.inventory_management.model.Customer;
import org.springframework.stereotype.Component;

// CustomerMapper.java
@Component
public class CustomerMapper {

    public CustomerResponseDTO toResponseDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setDni(customer.getDni());
        dto.setPhone(customer.getPhone());
        dto.setEmail(customer.getEmail());
        dto.setAddress(customer.getAddress());
        dto.setActive(customer.isActive());
        return dto;
    }

    public Customer toEntity(CustomerRequestDTO request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setDni(request.getDni());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setActive(true); // siempre activo al crear
        return customer;
    }
}