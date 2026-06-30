package com.calafate.inventory_management.controller;

import com.calafate.inventory_management.dto.branch.BranchRequestDTO;
import com.calafate.inventory_management.dto.branch.BranchResponseDTO;
import com.calafate.inventory_management.service.IBranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/branches")
public class BranchController {
    private final IBranchService branchService;

    //se utiliza ResponseEntity para que el front sepa que sucedió y poder tomar decisiones según la respuesta HTTP que recibe
    @GetMapping
    public ResponseEntity<List<BranchResponseDTO>> getAll(){
        return ResponseEntity.ok(branchService.getAll());
    }

    @PostMapping
    public ResponseEntity<BranchResponseDTO> create(@Valid @RequestBody BranchRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(branchService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BranchResponseDTO> update(@PathVariable Long id,@Valid @RequestBody BranchRequestDTO request){
        return ResponseEntity.ok(branchService.update(id,request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        branchService.delete(id);
        return ResponseEntity.noContent().build();

    }



}

