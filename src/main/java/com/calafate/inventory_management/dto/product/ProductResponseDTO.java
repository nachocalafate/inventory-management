package com.calafate.inventory_management.dto.product;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductResponseDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private Long categoryId;
    private String categoryName;  // útil para mostrar en el frontend sin otro request
}