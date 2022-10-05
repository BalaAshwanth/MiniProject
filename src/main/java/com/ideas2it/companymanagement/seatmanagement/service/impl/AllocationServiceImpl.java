package com.ideas2it.companymanagement.seatmanagement.service.impl;

import com.ideas2it.companymanagement.seatmanagement.dto.SeatDto;
import com.ideas2it.companymanagement.seatmanagement.entity.Seat;
import com.ideas2it.companymanagement.seatmanagement.helper.SeatHelper;
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

    public SeatDto insertSeatAllocation(SeatDto allocationDto) {
        return SeatHelper.changeSeatAllocationToDto(allocationRepository.save(SeatHelper.changeDtoToAllocationDetail(allocationDto)));
    }

    public SeatDto getSeatById(int id) {
        SeatDto allocationDto = null;
        Optional<Seat> allocationDetail = allocationRepository.findById(id);
        if (allocationDetail.isPresent()) {
            allocationDto = SeatHelper.changeSeatAllocationToDto(allocationDetail.get());
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

    public SeatDto updateSeat(SeatDto allocationDto) {
        return SeatHelper.changeSeatAllocationToDto(allocationRepository.save(SeatHelper.changeDtoToAllocationDetail(allocationDto)));
    }

    public List<SeatDto> getSeatDetails() {
        return allocationRepository.findAll().stream()
                .map(SeatHelper::changeSeatAllocationToDto).collect(Collectors.toList());
    }
}

