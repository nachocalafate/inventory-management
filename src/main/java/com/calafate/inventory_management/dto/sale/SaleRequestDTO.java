package com.calafate.inventory_management.dto.sale;

import lombok.Data;
import java.util.List;

@Data
public class SaleRequestDTO {
    private Long customerId;
    private Long branchId;
    private List<SaleDetailRequestDTO> details;
}