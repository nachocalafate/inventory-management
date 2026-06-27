package com.calafate.inventory_management.dto.sale;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleResponseDTO {
    private Long id;
    private LocalDateTime date;
    private BigDecimal total;
    private String customerFullName;   // firstName + lastName ya concatenados
    private Long customerId;
    private String branchName;
    private Long branchId;
    private List<SaleDetailResponseDTO> details;
}