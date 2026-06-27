package com.calafate.inventory_management.dto.sale;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SaleDetailResponseDTO {
    private Long id;
    private Long productId;
    private String productName;
    private String productCode;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;   // quantity * unitPrice, calculado en el mapper
}
