package com.calafate.inventory_management.mapper;

import com.calafate.inventory_management.dto.purchase.PurchaseDetailRequestDTO;
import com.calafate.inventory_management.dto.purchase.PurchaseDetailResponseDTO;
import com.calafate.inventory_management.dto.purchase.PurchaseRequestDTO;
import com.calafate.inventory_management.dto.purchase.PurchaseResponseDTO;
import com.calafate.inventory_management.model.Purchase;
import com.calafate.inventory_management.model.PurchaseDetail;
import com.calafate.inventory_management.repository.IProductRepository;
import com.calafate.inventory_management.repository.ISupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// PurchaseMapper.java
@Component
@RequiredArgsConstructor
public class PurchaseMapper {

    private final ISupplierRepository supplierRepository;
    private final IProductRepository productRepository;

    public PurchaseResponseDTO toResponseDTO(Purchase purchase) {
        PurchaseResponseDTO dto = new PurchaseResponseDTO();
        dto.setId(purchase.getId());
        dto.setDate(purchase.getDate());
        dto.setTotal(purchase.getTotal());
        dto.setSupplierId(purchase.getSupplier().getId());
        dto.setSupplierName(purchase.getSupplier().getName());
        dto.setDetails(purchase.getDetails()
                .stream()
                .map(this::toPurchaseDetailResponseDTO)
                .toList());
        return dto;
    }

    public Purchase toEntity(PurchaseRequestDTO request) {
        Purchase purchase = new Purchase();
        purchase.setDate(LocalDateTime.now());
        purchase.setSupplier(supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found")));
        purchase.setDetails(request.getDetails()
                .stream()
                .map(this::toPurchaseDetailEntity)
                .toList());
        return purchase;
    }

    private PurchaseDetailResponseDTO toPurchaseDetailResponseDTO(PurchaseDetail detail) {
        PurchaseDetailResponseDTO dto = new PurchaseDetailResponseDTO();
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

    private PurchaseDetail toPurchaseDetailEntity(PurchaseDetailRequestDTO request) {
        PurchaseDetail detail = new PurchaseDetail();
        detail.setQuantity(request.getQuantity());
        detail.setUnitPrice(request.getUnitPrice());
        detail.setProduct(productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found")));
        return detail;
    }
}