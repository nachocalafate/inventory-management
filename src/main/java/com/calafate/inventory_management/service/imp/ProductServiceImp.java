package com.calafate.inventory_management.service.imp;

import com.calafate.inventory_management.dto.product.ProductRequestDTO;
import com.calafate.inventory_management.dto.product.ProductResponseDTO;
import com.calafate.inventory_management.exception.ResourceNotFoundException;
import com.calafate.inventory_management.mapper.ProductMapper;
import com.calafate.inventory_management.model.Product;
import com.calafate.inventory_management.repository.IProductRepository;
import com.calafate.inventory_management.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// ProductServiceImpl.java
@Service
@RequiredArgsConstructor
public class ProductServiceImp implements IProductService {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO create(ProductRequestDTO request) {
        Product product = productMapper.toEntity(request);
        productRepository.save(product);
        return productMapper.toResponseDTO(product);
    }

    @Override
    public ProductResponseDTO getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return productMapper.toResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.toResponseDTO(product))
                .toList();
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        productRepository.save(product);
        return productMapper.toResponseDTO(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDTO deactivate(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setActive(false);
        productRepository.save(product);
        return productMapper.toResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllActive() {
        return productRepository.findByActiveTrue()
                .stream()
                .map(product -> productMapper.toResponseDTO(product))
                .toList();
    }

    @Override
    public ProductResponseDTO getByCode(String code) {
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return productMapper.toResponseDTO(product);
    }
}