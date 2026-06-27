package com.calafate.inventory_management.dto.customer;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String phone;
    private String email;
    private String address;
    private boolean active;
}