package com.calafate.inventory_management.dto.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplierRequestDTO {
    @NotBlank(message = "The name is mandatory")
    private String name;
    @NotBlank (message = "The phone is mandatory")
    private String phone;
    @NotBlank (message = "The email is mandatory")
    @Email (message = "The email format is invalid")
    private String email;
    private String address;
}