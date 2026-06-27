package com.calafate.inventory_management.dto.supplier;

import lombok.Data;

@Data
public class SupplierRequestDTO {
    private String name;
    private String phone;
    private String email;
    private String address;
}