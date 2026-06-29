package com.calafate.inventory_management.service;


import com.calafate.inventory_management.dto.supplier.SupplierRequestDTO;
import com.calafate.inventory_management.dto.supplier.SupplierResponseDTO;

import java.util.List;

public interface ISupplierService {
    SupplierResponseDTO create(SupplierRequestDTO request);
    SupplierResponseDTO getById(Long id);
    List<SupplierResponseDTO> getAll();
    SupplierResponseDTO update(Long id, SupplierRequestDTO request);
    void delete(Long id);
}