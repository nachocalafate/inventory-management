package com.calafate.inventory_management.service.imp;

import com.calafate.inventory_management.dto.category.CategoryRequestDTO;
import com.calafate.inventory_management.dto.category.CategoryResponseDTO;
import com.calafate.inventory_management.mapper.CategoryMapper;
import com.calafate.inventory_management.model.Category;
import com.calafate.inventory_management.repository.ICategoryRepository;
import com.calafate.inventory_management.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements ICategoryService {


    private final ICategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO request) {
        Category category = categoryMapper.toEntity(request);
        categoryRepository.save(category);
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> categoryMapper.toResponseDTO(category))
                .toList();
    }

    @Override
    public CategoryResponseDTO update(Long id, CategoryRequestDTO request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        categoryRepository.save(category);
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.deleteById(id);
    }
}