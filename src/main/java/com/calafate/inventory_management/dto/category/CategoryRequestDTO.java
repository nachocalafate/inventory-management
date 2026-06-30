package com.calafate.inventory_management.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDTO {
    @NotBlank (message = "The name is mandatory")
    private String name;
    @NotBlank (message = "The description is mandatory")
    private String description;
}
