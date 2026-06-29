package com.calafate.inventory_management.service;


import com.calafate.inventory_management.dto.sale.SaleRequestDTO;
import com.calafate.inventory_management.dto.sale.SaleResponseDTO;

import java.util.List;

public interface ISaleService {
    SaleResponseDTO create(SaleRequestDTO request);
    SaleResponseDTO getById(Long id);
    List<SaleResponseDTO> getAll();
    List<SaleResponseDTO> getByCustomerId(Long customerId);
    List<SaleResponseDTO> getByBranchId(Long branchId);
}