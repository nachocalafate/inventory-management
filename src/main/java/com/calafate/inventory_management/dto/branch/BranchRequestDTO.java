package com.calafate.inventory_management.dto.branch;

import lombok.Data;

@Data
public class BranchRequestDTO {
    private String name;
    private String description;
    private String address;
    private String phone;
}