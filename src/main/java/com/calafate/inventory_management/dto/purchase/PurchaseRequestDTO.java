package com.calafate.inventory_management.dto.purchase;

import lombok.Data;
import java.util.List;

@Data
public class PurchaseRequestDTO {
    private Long supplierId;
    private Long branchId;
    private List<PurchaseDetailRequestDTO> details;
}