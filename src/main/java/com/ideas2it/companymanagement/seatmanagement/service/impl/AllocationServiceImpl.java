package com.ideas2it.companymanagement.seatmanagement.service.impl;

import com.ideas2it.companymanagement.seatmanagement.dto.AllocationDto;
import com.ideas2it.companymanagement.seatmanagement.entity.Allocation;
import com.ideas2it.companymanagement.seatmanagement.helper.AllocationHelper;
import com.ideas2it.companymanagement.seatmanagement.repository.AllocationRepository;
import com.ideas2it.companymanagement.seatmanagement.service.AllocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AllocationServiceImpl implements AllocationService {
    private final AllocationRepository allocationRepository;

    public AllocationServiceImpl(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public AllocationDto insertSeatAllocation(AllocationDto allocationDto) {
        return AllocationHelper.changeSeatAllocationToDto(allocationRepository.save(AllocationHelper.changeDtoToAllocationDetail(allocationDto)));
    }

    public AllocationDto getSeatById(int id) {
        AllocationDto allocationDto = null;
        Optional<Allocation> allocationDetail = allocationRepository.findById(id);
        if (allocationDetail.isPresent()) {
            allocationDto = AllocationHelper.changeSeatAllocationToDto(allocationDetail.get());
        }
        return allocationDto;
    }

    public boolean deleteEmployeeById(int id) {
        if (allocationRepository.existsById(id)) {
            allocationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public AllocationDto updateSeat(AllocationDto allocationDto) {
        return AllocationHelper.changeSeatAllocationToDto(allocationRepository.save(AllocationHelper.changeDtoToAllocationDetail(allocationDto)));
    }

    public List<AllocationDto> getSeatDetails() {
        return allocationRepository.findAll().stream()
                .map(AllocationHelper::changeSeatAllocationToDto).collect(Collectors.toList());
    }
}

