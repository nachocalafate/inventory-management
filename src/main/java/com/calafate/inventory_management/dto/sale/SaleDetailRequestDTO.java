package com.calafate.inventory_management.dto.sale;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SaleDetailRequestDTO {
    private Long productId;
    private Integer quantity;
    private BigDecimal unitPrice;
}