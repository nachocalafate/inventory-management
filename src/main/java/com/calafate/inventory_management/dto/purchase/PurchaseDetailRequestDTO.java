package com.calafate.inventory_management.dto.purchase;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PurchaseDetailRequestDTO {
    private Long productId;
    private Integer quantity;
    private BigDecimal unitPrice;
}