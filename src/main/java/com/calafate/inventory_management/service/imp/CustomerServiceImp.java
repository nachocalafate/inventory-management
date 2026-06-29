package com.calafate.inventory_management.service.imp;

import com.calafate.inventory_management.dto.customer.CustomerRequestDTO;
import com.calafate.inventory_management.dto.customer.CustomerResponseDTO;
import com.calafate.inventory_management.mapper.CustomerMapper;
import com.calafate.inventory_management.model.Customer;
import com.calafate.inventory_management.repository.ICustomerRepository;
import com.calafate.inventory_management.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// CustomerServiceImpl.java
@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO create(CustomerRequestDTO request) {
        Customer customer = customerMapper.toEntity(request);
        customerRepository.save(customer);
        return customerMapper.toResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO getById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toResponseDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> customerMapper.toResponseDTO(customer))
                .toList();
    }

    @Override
    public CustomerResponseDTO update(Long id, CustomerRequestDTO request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setDni(request.getDni());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customerRepository.save(customer);
        return customerMapper.toResponseDTO(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponseDTO deactivate(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setActive(false);
        customerRepository.save(customer);
        return customerMapper.toResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO getByDni(String dni) {
        Customer customer = customerRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toResponseDTO(customer);
    }
}