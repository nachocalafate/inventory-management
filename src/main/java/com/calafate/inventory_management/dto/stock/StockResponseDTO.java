package com.calafate.inventory_management.dto.stock;

import lombok.Data;

@Data
public class StockResponseDTO {
    private Long id;
    private Integer quantity;
    private Long productId;
    private String productName;
    private String productCode;
    private Long branchId;
    private String branchName;
}