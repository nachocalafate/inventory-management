package com.calafate.inventory_management.dto.purchase;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PurchaseDetailResponseDTO {
    private Long id;
    private Long productId;
    private String productName;
    private String productCode;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
}