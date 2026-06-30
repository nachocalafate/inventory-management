package com.calafate.inventory_management.controller;

import com.calafate.inventory_management.dto.purchase.PurchaseRequestDTO;
import com.calafate.inventory_management.dto.purchase.PurchaseResponseDTO;
import com.calafate.inventory_management.service.IPurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    private final IPurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> create(@Valid @RequestBody PurchaseRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponseDTO>> getAll() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<PurchaseResponseDTO>> getBySupplierId(@PathVariable Long supplierId) {
        return ResponseEntity.ok(purchaseService.getBySupplierId(supplierId));
    }
}