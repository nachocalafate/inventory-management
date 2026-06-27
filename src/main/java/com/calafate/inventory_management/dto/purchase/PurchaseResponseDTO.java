package com.calafate.inventory_management.dto.purchase;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseResponseDTO {
    private Long id;
    private LocalDateTime date;
    private BigDecimal total;
    private Long supplierId;
    private String supplierName;
    private List<PurchaseDetailResponseDTO> details;
}