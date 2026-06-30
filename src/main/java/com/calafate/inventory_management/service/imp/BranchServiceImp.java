
package com.calafate.inventory_management.service.impl;

import com.calafate.inventory_management.dto.branch.BranchRequestDTO;
import com.calafate.inventory_management.dto.branch.BranchResponseDTO;
import com.calafate.inventory_management.exception.ResourceNotFoundException;
import com.calafate.inventory_management.mapper.BranchMapper;
import com.calafate.inventory_management.model.Branch;
import com.calafate.inventory_management.repository.IBranchRepository;
import com.calafate.inventory_management.service.IBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImp implements IBranchService {

    private final IBranchRepository branchRepository;
    private final BranchMapper branchMapper;

    @Override
    public BranchResponseDTO create(BranchRequestDTO request) {
        Branch branch = branchMapper.toEntity(request);
        branchRepository.save(branch);
        return branchMapper.toResponseDTO(branch);
    }

    @Override
    public BranchResponseDTO getById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
        return branchMapper.toResponseDTO(branch);
    }

    @Override
    public List<BranchResponseDTO> getAll() {
        return branchRepository.findAll()
                .stream()
                .map(branch -> branchMapper.toResponseDTO(branch))
                .toList();
    }

    @Override
    public BranchResponseDTO update(Long id, BranchRequestDTO request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());
        branch.setDescription(request.getDescription());
        branchRepository.save(branch);
        return branchMapper.toResponseDTO(branch);
    }

    @Override
    public void delete(Long id) {
        branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
        branchRepository.deleteById(id);
    }
}