package com.ideas2it.companymanagement.seatmanagement.service;

import com.ideas2it.companymanagement.seatmanagement.dto.SeatDto;

import java.util.List;

public interface AllocationService {
    SeatDto insertSeatAllocation(SeatDto allocationDto);

    SeatDto getSeatById(int id);

    boolean deleteEmployeeById(int id);

    SeatDto updateSeat(SeatDto allocationDto);

    List<SeatDto> getSeatDetails();

}
