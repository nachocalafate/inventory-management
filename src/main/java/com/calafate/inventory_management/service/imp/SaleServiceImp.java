package com.calafate.inventory_management.service.imp;

import com.calafate.inventory_management.dto.sale.SaleDetailRequestDTO;
import com.calafate.inventory_management.dto.sale.SaleRequestDTO;
import com.calafate.inventory_management.dto.sale.SaleResponseDTO;
import com.calafate.inventory_management.exception.InsufficientStockException;
import com.calafate.inventory_management.exception.ResourceNotFoundException;
import com.calafate.inventory_management.mapper.SaleMapper;
import com.calafate.inventory_management.model.Sale;
import com.calafate.inventory_management.model.Stock;
import com.calafate.inventory_management.repository.ISaleRepository;
import com.calafate.inventory_management.repository.IStockRepository;
import com.calafate.inventory_management.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

// SaleServiceImpl.java
@Service
@RequiredArgsConstructor
public class SaleServiceImp implements ISaleService {

    private final ISaleRepository saleRepository;
    private final IStockRepository stockRepository;
    private final SaleMapper saleMapper;

    @Override
    public SaleResponseDTO create(SaleRequestDTO request) {
        // verificar stock y descontarlo
        for (SaleDetailRequestDTO detail : request.getDetails()) {
            Stock stock = stockRepository
                    .findByProductIdAndBranchId(detail.getProductId(), request.getBranchId())
                    .orElseThrow(() -> new ResourceNotFoundException("Stock not found for product: "
                            + detail.getProductId()));

            if (stock.getQuantity() < detail.getQuantity()) {
                throw new InsufficientStockException("Insufficient stock for product: "
                        + detail.getProductId());
            }

            stock.setQuantity(stock.getQuantity() - detail.getQuantity());
            stockRepository.save(stock);
        }


        Sale sale = saleMapper.toEntity(request);

        // calcular total
        BigDecimal total = request.getDetails()
                .stream()
                .map(detail -> detail.getUnitPrice()
                        .multiply(new BigDecimal(detail.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setTotal(total);

        // guardar y devolver
        saleRepository.save(sale);
        return saleMapper.toResponseDTO(sale);
    }

    @Override
    public SaleResponseDTO getById(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));
        return saleMapper.toResponseDTO(sale);
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        return saleRepository.findAll()
                .stream()
                .map(sale -> saleMapper.toResponseDTO(sale))
                .toList();
    }

    @Override
    public List<SaleResponseDTO> getByCustomerId(Long customerId) {
        return saleRepository.findByCustomerId(customerId)
                .stream()
                .map(sale -> saleMapper.toResponseDTO(sale))
                .toList();
    }

    @Override
    public List<SaleResponseDTO> getByBranchId(Long branchId) {
        return saleRepository.findByBranchId(branchId)
                .stream()
                .map(sale -> saleMapper.toResponseDTO(sale))
                .toList();
    }
}