package com.calafate.inventory_management.service;

import com.calafate.inventory_management.dto.stock.StockResponseDTO;
import java.util.List;

public interface IStockService {
    StockResponseDTO getById(Long id);
    List<StockResponseDTO> getAll();
    List<StockResponseDTO> getByBranchId(Long branchId);
    List<StockResponseDTO> getByProductId(Long productId);
}