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

/**
 * <p>
 * Implementation for handling all business logics of asset model
 * </p>
 */
@Service
public class AllocationServiceImpl implements AllocationService {
    private final AllocationRepository allocationRepository;

    public AllocationServiceImpl(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    /**
     * <p>
     * This method is used to save allocation dto objects to seat detail.
     * </p>
     *
     * @param seatDto
     *
     * @return SeatDto
     */
    public SeatDto insertSeat(SeatDto seatDto) {
        return SeatHelper.changeSeatAllocationToDto(allocationRepository.save(SeatHelper.changeDtoToAllocationDetail(seatDto)));
    }

    /**
     * <p>
     * Retrieves seat from repository by id.
     * </p>
     *
     * @param id
     *
     * @return seatDto
     *
     */
    public SeatDto getSeat(int id) {
        SeatDto seatDto = null;
        Optional<Seat> allocationDetail = allocationRepository.findById(id);
        if (allocationDetail.isPresent()) {
            seatDto = SeatHelper.changeSeatAllocationToDto(allocationDetail.get());
        }
        return seatDto;
    }

    /**
     * <p>
     * Deletes seat detail by id.
     * </p>
     *
     * @param id
     *
     * @return boolean
     *
     */
    public boolean deleteSeat(int id) {
        if (allocationRepository.existsById(id)) {
            allocationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * This is to update the seat detail.
     * </p>
     *
     * @param allocationDto
     *
     * @return SeatDto
     *
     */
    public SeatDto updateSeat(SeatDto allocationDto) {
        return SeatHelper.changeSeatAllocationToDto(allocationRepository.save(SeatHelper.changeDtoToAllocationDetail(allocationDto)));
    }

    /**
     * <p>
     * Retrieves all seat detail from the database.
     * </p>
     *
     * @return  List<SeatDto>
     */
    public List<SeatDto> getAllSeat() {
        return allocationRepository.findAll().stream()
                .map(SeatHelper::changeSeatAllocationToDto).collect(Collectors.toList());
    }
}

