package com.calafate.inventory_management.service.imp;

import com.calafate.inventory_management.dto.supplier.SupplierRequestDTO;
import com.calafate.inventory_management.dto.supplier.SupplierResponseDTO;
import com.calafate.inventory_management.exception.ResourceNotFoundException;
import com.calafate.inventory_management.mapper.SupplierMapper;
import com.calafate.inventory_management.model.Supplier;
import com.calafate.inventory_management.repository.ISupplierRepository;
import com.calafate.inventory_management.service.ISupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// SupplierServiceImpl.java
@Service
@RequiredArgsConstructor
public class SupplierServiceImp implements ISupplierService {

    private final ISupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public SupplierResponseDTO create(SupplierRequestDTO request) {
        Supplier supplier = supplierMapper.toEntity(request);
        supplierRepository.save(supplier);
        return supplierMapper.toResponseDTO(supplier);
    }

    @Override
    public SupplierResponseDTO getById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        return supplierMapper.toResponseDTO(supplier);
    }

    @Override
    public List<SupplierResponseDTO> getAll() {
        return supplierRepository.findAll()
                .stream()
                .map(supplier -> supplierMapper.toResponseDTO(supplier))
                .toList();
    }

    @Override
    public SupplierResponseDTO update(Long id, SupplierRequestDTO request) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        supplier.setName(request.getName());
        supplier.setPhone(request.getPhone());
        supplier.setEmail(request.getEmail());
        supplier.setAddress(request.getAddress());
        supplierRepository.save(supplier);
        return supplierMapper.toResponseDTO(supplier);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        supplierRepository.deleteById(id);
    }
}