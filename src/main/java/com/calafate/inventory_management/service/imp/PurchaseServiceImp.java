package com.calafate.inventory_management.service.imp;

import com.calafate.inventory_management.dto.purchase.PurchaseDetailRequestDTO;
import com.calafate.inventory_management.dto.purchase.PurchaseRequestDTO;
import com.calafate.inventory_management.dto.purchase.PurchaseResponseDTO;
import com.calafate.inventory_management.exception.ResourceNotFoundException;
import com.calafate.inventory_management.mapper.PurchaseMapper;
import com.calafate.inventory_management.mapper.StockMapper;
import com.calafate.inventory_management.model.Purchase;
import com.calafate.inventory_management.model.Stock;
import com.calafate.inventory_management.repository.IPurchaseRepository;
import com.calafate.inventory_management.repository.IStockRepository;
import com.calafate.inventory_management.service.IPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PurchaseServiceImp implements IPurchaseService {

    private final IPurchaseRepository purchaseRepository;
    private final IStockRepository stockRepository;
    private final StockMapper stockMapper;
    private final PurchaseMapper purchaseMapper;

    @Override
    public PurchaseResponseDTO create(PurchaseRequestDTO request) {
        // convertir a entidad
        Purchase purchase = purchaseMapper.toEntity(request);

        // calcula total
        BigDecimal total = request.getDetails()
                .stream()
                .map(detail -> detail.getUnitPrice()
                        .multiply(new BigDecimal(detail.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        purchase.setTotal(total);

        //guarda la compra
        purchaseRepository.save(purchase);

        // actualiza stock por cada detalle
        for (PurchaseDetailRequestDTO detail : request.getDetails()) {
            Optional<Stock> existingStock = stockRepository
                    .findByProductIdAndBranchId(detail.getProductId(), request.getBranchId());

            if (existingStock.isPresent()) {
                // si ya existe el stock lo sumamos
                Stock stock = existingStock.get();
                stock.setQuantity(stock.getQuantity() + detail.getQuantity());
                stockRepository.save(stock);
            } else {
                // si no existe lo creamos
                Stock newStock = stockMapper.toEntity(
                        detail.getProductId(),
                        request.getBranchId(),
                        detail.getQuantity()
                );
                stockRepository.save(newStock);
            }
        }

        return purchaseMapper.toResponseDTO(purchase);
    }

    @Override
    public PurchaseResponseDTO getById(Long id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found"));
        return purchaseMapper.toResponseDTO(purchase);
    }

    @Override
    public List<PurchaseResponseDTO> getAll() {
        return purchaseRepository.findAll()
                .stream()
                .map(purchase -> purchaseMapper.toResponseDTO(purchase))
                .toList();
    }

    @Override
    public List<PurchaseResponseDTO> getBySupplierId(Long supplierId) {
        return purchaseRepository.findBySupplierId(supplierId)
                .stream()
                .map(purchase -> purchaseMapper.toResponseDTO(purchase))
                .toList();
    }
}