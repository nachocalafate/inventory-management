package com.calafate.inventory_management.service;

import com.calafate.inventory_management.dto.product.ProductRequestDTO;
import com.calafate.inventory_management.dto.product.ProductResponseDTO;

import java.util.List;

// IProductService.java
public interface IProductService {
    ProductResponseDTO create(ProductRequestDTO request);
    ProductResponseDTO getById(Long id);
    List<ProductResponseDTO> getAll();
    ProductResponseDTO update(Long id, ProductRequestDTO request);
    void delete(Long id);
    ProductResponseDTO deactivate(Long id);
    List<ProductResponseDTO> getAllActive();
    ProductResponseDTO getByCode(String code);
}