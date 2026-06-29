package com.calafate.inventory_management.mapper;
import com.calafate.inventory_management.dto.category.CategoryRequestDTO;
import com.calafate.inventory_management.dto.category.CategoryResponseDTO;
import com.calafate.inventory_management.model.Category;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {

    public CategoryResponseDTO toResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    public Category toEntity(CategoryRequestDTO request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return category;
    }
}