package com.calafate.inventory_management.dto.product;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductRequestDTO {
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;  // solo el ID, no el objeto completo
}