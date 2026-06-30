package com.calafate.inventory_management.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequestDTO {
    @NotBlank(message = "The firstname is mandatory")
    private String firstName;
    @NotBlank(message = "The lastname is mandatory")
    private String lastName;
    @NotBlank(message = "The DNI is mandatory")
    private String dni;
    private String phone;
    @NotBlank (message = "The email is mandatory")
    @Email (message = "The email format is invalid")
    private String email;
    private String address;
}