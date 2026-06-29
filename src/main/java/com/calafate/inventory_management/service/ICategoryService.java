package com.calafate.inventory_management.service;


import com.calafate.inventory_management.dto.branch.BranchRequestDTO;
import com.calafate.inventory_management.dto.category.CategoryRequestDTO;
import com.calafate.inventory_management.dto.category.CategoryResponseDTO;

import java.util.List;

public interface ICategoryService {
    CategoryResponseDTO create(CategoryRequestDTO request);
    CategoryResponseDTO getById(Long id);
    List<CategoryResponseDTO> getAll();
    CategoryResponseDTO update(Long id, CategoryRequestDTO request);
    void delete(Long id);
}