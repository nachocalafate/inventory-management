package com.calafate.inventory_management.controller;

import com.calafate.inventory_management.dto.sale.SaleRequestDTO;
import com.calafate.inventory_management.dto.sale.SaleResponseDTO;
import com.calafate.inventory_management.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sales")

public class SaleController {

    private final ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> create(@RequestBody SaleRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(saleService.getById(id));

    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAll(){
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<SaleResponseDTO>> getByCustomerId(@PathVariable Long customerId){
        return ResponseEntity.ok(saleService.getByCustomerId(customerId));

    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<SaleResponseDTO>>getByBranchId(@PathVariable Long branchId){
        return ResponseEntity.ok(saleService.getByBranchId(branchId));
    }
}
