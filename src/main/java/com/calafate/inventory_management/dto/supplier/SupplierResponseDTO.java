package com.calafate.inventory_management.dto.supplier;

import lombok.Data;

@Data
public class SupplierResponseDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
}