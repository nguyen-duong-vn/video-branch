package com.codegym.demo20.service.Impl;

import com.codegym.demo20.dto.BranchDto;
import com.codegym.demo20.entity.Branch;
import com.codegym.demo20.repository.BranchRepository;
import com.codegym.demo20.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService implements IBranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<BranchDto> getAll() {
        List<Branch> branches = branchRepository.findAll();
        List<BranchDto> branchDtos = new ArrayList<>();
        for(Branch branch : branches) {
            BranchDto branchDto = new BranchDto();
            branchDto.setId(branch.getId());
            branchDto.setName(branch.getName());
            branchDtos.add(branchDto);
        }
        return branchDtos;
    }
}
