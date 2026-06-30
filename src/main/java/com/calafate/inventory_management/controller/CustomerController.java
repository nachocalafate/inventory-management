package com.calafate.inventory_management.controller;

import com.calafate.inventory_management.dto.customer.CustomerRequestDTO;
import com.calafate.inventory_management.dto.customer.CustomerResponseDTO;
import com.calafate.inventory_management.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(@Valid @RequestBody CustomerRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@PathVariable Long id,@Valid @RequestBody CustomerRequestDTO request) {
        return ResponseEntity.ok(customerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<CustomerResponseDTO> deactivate(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deactivate(id));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<CustomerResponseDTO> getByDni(@PathVariable String dni) {
        return ResponseEntity.ok(customerService.getByDni(dni));
    }
}