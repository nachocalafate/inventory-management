package com.calafate.inventory_management.dto.branch;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BranchRequestDTO {

    @NotBlank(message = "The name is mandatory")
    private String name;
    @NotBlank (message = "The description is mandatory")
    private String description;
    @NotBlank (message = "The address is mandatory")
    private String address;
    private String phone;
}