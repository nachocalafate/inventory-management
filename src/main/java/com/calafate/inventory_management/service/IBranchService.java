// BranchService.java
package com.calafate.inventory_management.service;

import com.calafate.inventory_management.dto.branch.BranchRequestDTO;
import com.calafate.inventory_management.dto.branch.BranchResponseDTO;
import java.util.List;

public interface IBranchService {
    BranchResponseDTO create(BranchRequestDTO request);
    BranchResponseDTO getById(Long id);
    List<BranchResponseDTO> getAll();
    BranchResponseDTO update(Long id, BranchRequestDTO request);
    void delete(Long id);
}