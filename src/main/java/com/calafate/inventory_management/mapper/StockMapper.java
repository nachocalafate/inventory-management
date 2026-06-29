package com.calafate.inventory_management.mapper;


import com.calafate.inventory_management.dto.stock.StockResponseDTO;
import com.calafate.inventory_management.model.Stock;
import com.calafate.inventory_management.repository.IBranchRepository;
import com.calafate.inventory_management.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockMapper {

    private final IProductRepository productRepository;
    private final IBranchRepository branchRepository;

    public StockResponseDTO toResponseDTO(Stock stock) {
        StockResponseDTO dto = new StockResponseDTO();
        dto.setId(stock.getId());
        dto.setQuantity(stock.getQuantity());
        dto.setProductId(stock.getProduct().getId());
        dto.setProductName(stock.getProduct().getName());
        dto.setProductCode(stock.getProduct().getCode());
        dto.setBranchId(stock.getBranch().getId());
        dto.setBranchName(stock.getBranch().getName());
        return dto;
    }

    public Stock toEntity(Long productId, Long branchId, Integer quantity) {
        Stock stock = new Stock();
        stock.setQuantity(quantity);
        stock.setProduct(productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found")));
        stock.setBranch(branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found")));
        return stock;
    }
}