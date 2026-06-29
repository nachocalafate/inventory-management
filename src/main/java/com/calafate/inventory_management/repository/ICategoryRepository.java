package com.calafate.inventory_management.repository;

import com.calafate.inventory_management.dto.category.CategoryRequestDTO;
import com.calafate.inventory_management.dto.category.CategoryResponseDTO;
import com.calafate.inventory_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}