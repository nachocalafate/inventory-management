package com.calafate.inventory_management.mapper;

import com.calafate.inventory_management.dto.branch.BranchRequestDTO;
import com.calafate.inventory_management.dto.branch.BranchResponseDTO;
import com.calafate.inventory_management.model.Branch;
import org.springframework.stereotype.Component;

@Component //Spring lo detecta como un bean y gracias a esto puedo inyectarlo en distintos lugares
public class BranchMapper {

    public BranchResponseDTO toResponseDTO(Branch branch) {
        BranchResponseDTO branchAux = new BranchResponseDTO();
        branchAux.setId(branch.getId());
        branchAux.setAddress(branch.getAddress());
        branchAux.setName(branch.getName());
        branchAux.setPhone(branch.getPhone());
        branchAux.setDescription(branch.getDescription());
        return branchAux;
    }

    public Branch toEntity(BranchRequestDTO request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());
        branch.setDescription(request.getDescription());
        return branch;
    }
}