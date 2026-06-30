package com.calafate.inventory_management.controller;

import com.calafate.inventory_management.dto.stock.StockResponseDTO;
import com.calafate.inventory_management.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final IStockService stockService;

    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getAll() {
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<StockResponseDTO>> getByBranchId(@PathVariable Long branchId) {
        return ResponseEntity.ok(stockService.getByBranchId(branchId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<StockResponseDTO>> getByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(stockService.getByProductId(productId));
    }
}