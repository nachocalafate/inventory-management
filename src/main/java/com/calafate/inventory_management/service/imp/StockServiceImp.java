package com.calafate.inventory_management.service.imp;


import com.calafate.inventory_management.dto.stock.StockResponseDTO;
import com.calafate.inventory_management.exception.ResourceNotFoundException;
import com.calafate.inventory_management.mapper.StockMapper;
import com.calafate.inventory_management.model.Stock;
import com.calafate.inventory_management.repository.IStockRepository;
import com.calafate.inventory_management.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImp implements IStockService {

    private final IStockRepository stockRepository;
    private final StockMapper stockMapper;

    @Override
    public StockResponseDTO getById(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
        return stockMapper.toResponseDTO(stock);
    }

    @Override
    public List<StockResponseDTO> getAll() {
        return stockRepository.findAll()
                .stream()
                .map(stock -> stockMapper.toResponseDTO(stock))
                .toList();
    }

    @Override
    public List<StockResponseDTO> getByBranchId(Long branchId) {
        return stockRepository.findByBranchId(branchId)
                .stream()
                .map(stock -> stockMapper.toResponseDTO(stock))
                .toList();
    }

    @Override
    public List<StockResponseDTO> getByProductId(Long productId) {
        return stockRepository.findByProductId(productId)
                .stream()
                .map(stock -> stockMapper.toResponseDTO(stock))
                .toList();
    }
}