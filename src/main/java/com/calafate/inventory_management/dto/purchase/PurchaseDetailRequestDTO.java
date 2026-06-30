package com.calafate.inventory_management.dto.purchase;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class PurchaseDetailRequestDTO {
    @NotNull(message = "The product ID is mandatory")
    private Long productId;
    @NotNull(message = "Quantity is mandatory")
    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;
    @NotNull(message = "Unit price is mandatory")
    @Positive(message = "Unit price must be greater than zero")
    private BigDecimal unitPrice;
}