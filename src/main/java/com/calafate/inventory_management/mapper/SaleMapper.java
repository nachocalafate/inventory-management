package com.calafate.inventory_management.mapper;

import com.calafate.inventory_management.dto.sale.SaleDetailRequestDTO;
import com.calafate.inventory_management.dto.sale.SaleDetailResponseDTO;
import com.calafate.inventory_management.dto.sale.SaleRequestDTO;
import com.calafate.inventory_management.dto.sale.SaleResponseDTO;
import com.calafate.inventory_management.model.Sale;
import com.calafate.inventory_management.model.SaleDetail;
import com.calafate.inventory_management.repository.IBranchRepository;
import com.calafate.inventory_management.repository.ICustomerRepository;
import com.calafate.inventory_management.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SaleMapper {

    private final ICustomerRepository customerRepository;
    private final IBranchRepository branchRepository;
    private final IProductRepository productRepository;

    public SaleResponseDTO toResponseDTO(Sale sale) {
        SaleResponseDTO dto = new SaleResponseDTO();
        dto.setId(sale.getId());
        dto.setDate(sale.getDate());
        dto.setTotal(sale.getTotal());
        dto.setCustomerId(sale.getCustomer().getId());
        dto.setCustomerFullName(sale.getCustomer().getFirstName() + " " + sale.getCustomer().getLastName());
        dto.setBranchId(sale.getBranch().getId());
        dto.setBranchName(sale.getBranch().getName());
        dto.setDetails(sale.getDetails()
                .stream()
                .map(this::toSaleDetailResponseDTO)
                .toList());
        return dto;
    }

    public Sale toEntity(SaleRequestDTO request) {
        Sale sale = new Sale();
        sale.setDate(LocalDateTime.now());
        sale.setCustomer(customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")));
        sale.setBranch(branchRepository.findById(request.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found")));
        sale.setDetails(request.getDetails()
                .stream()
                .map(this::toSaleDetailEntity)
                .toList());
        return sale;
    }

    private SaleDetailResponseDTO toSaleDetailResponseDTO(SaleDetail detail) {
        SaleDetailResponseDTO dto = new SaleDetailResponseDTO();
        dto.setId(detail.getId());
        dto.setProductId(detail.getProduct().getId());
        dto.setProductName(detail.getProduct().getName());
        dto.setProductCode(detail.getProduct().getCode());
        dto.setQuantity(detail.getQuantity());
        dto.setUnitPrice(detail.getUnitPrice());
        dto.setSubtotal(detail.getUnitPrice()
                .multiply(new BigDecimal(detail.getQuantity())));
        return dto;
    }

    private SaleDetail toSaleDetailEntity(SaleDetailRequestDTO request) {
        SaleDetail detail = new SaleDetail();
        detail.setQuantity(request.getQuantity());
        detail.setUnitPrice(request.getUnitPrice());
        detail.setProduct(productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found")));
        return detail;
    }
}