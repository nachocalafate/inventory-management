package com.calafate.inventory_management.mapper;

import com.calafate.inventory_management.dto.product.ProductRequestDTO;
import com.calafate.inventory_management.dto.product.ProductResponseDTO;
import com.calafate.inventory_management.model.Category;
import com.calafate.inventory_management.model.Product;
import com.calafate.inventory_management.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// ProductMapper.java
@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ICategoryRepository categoryRepository;

    public ProductResponseDTO toResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setCode(product.getCode());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setActive(product.isActive());
        //Estos dos metodos de producto devuelven un objeto de tipo Category, por lo que necesito usar los metodos de Category
        //para conseguir su Id y Name
        dto.setCategoryId(product.getCategory().getId());
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }

    public Product toEntity(ProductRequestDTO request) {
        Product product = new Product();
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setActive(true);
        //El ProductRequestDTO solo trae un categoryId (un numero). Pero la entidad Product necesita un objeto Category completo
        //para armar la relacion JPA. Entonces va a la base de datos, busca la Category por ese id, y si no existe lanza una excepcion.
        //Si existe se la asigna a producto
        Category categoryAux = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(categoryAux);
        return product;
    }
}