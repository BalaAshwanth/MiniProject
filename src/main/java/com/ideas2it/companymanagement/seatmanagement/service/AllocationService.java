package com.ideas2it.companymanagement.seatmanagement.service;

import com.ideas2it.companymanagement.seatmanagement.dto.AllocationDto;

import java.util.List;

public interface AllocationService {
    AllocationDto insertSeatAllocation(AllocationDto allocationDto);
    AllocationDto getSeatById(int id);
    boolean deleteEmployeeById(int id);
    AllocationDto updateSeat(AllocationDto allocationDto);
    List<AllocationDto> getSeatDetails();

}
