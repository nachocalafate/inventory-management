package com.calafate.inventory_management.dto.customer;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private String firstName;
    private String lastName;
    private String dni;
    private String phone;
    private String email;
    private String address;
}