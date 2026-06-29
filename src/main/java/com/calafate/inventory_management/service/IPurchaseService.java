package com.calafate.inventory_management.service;

import com.calafate.inventory_management.dto.purchase.PurchaseRequestDTO;
import com.calafate.inventory_management.dto.purchase.PurchaseResponseDTO;
import java.util.List;


public interface IPurchaseService {
    PurchaseResponseDTO create(PurchaseRequestDTO request);
    PurchaseResponseDTO getById(Long id);
    List<PurchaseResponseDTO> getAll();
    List<PurchaseResponseDTO> getBySupplierId(Long supplierId);
}
