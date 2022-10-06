package com.ideas2it.companymanagement.seatmanagement.service;

import com.ideas2it.companymanagement.seatmanagement.dto.SeatDto;

import java.util.List;

public interface AllocationService {
    SeatDto insertSeat(SeatDto allocationDto);

    SeatDto getSeat(int id);

    boolean deleteSeat(int id);

    SeatDto updateSeat(SeatDto allocationDto);

    List<SeatDto> getAllSeat();

}
