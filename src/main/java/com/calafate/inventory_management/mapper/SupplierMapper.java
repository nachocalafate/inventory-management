package com.calafate.inventory_management.mapper;

import com.calafate.inventory_management.dto.supplier.SupplierRequestDTO;
import com.calafate.inventory_management.dto.supplier.SupplierResponseDTO;
import com.calafate.inventory_management.model.Supplier;
import org.springframework.stereotype.Component;

// SupplierMapper.java
@Component
public class SupplierMapper {

    public SupplierResponseDTO toResponseDTO(Supplier supplier) {
        SupplierResponseDTO dto = new SupplierResponseDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setPhone(supplier.getPhone());
        dto.setEmail(supplier.getEmail());
        dto.setAddress(supplier.getAddress());
        return dto;
    }

    public Supplier toEntity(SupplierRequestDTO request) {
        Supplier supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setPhone(request.getPhone());
        supplier.setEmail(request.getEmail());
        supplier.setAddress(request.getAddress());
        return supplier;
    }
}