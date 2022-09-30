package com.ideas2it.companymanagement.seatmanagement.helper;

import com.ideas2it.companymanagement.seatmanagement.entity.Allocation;
import com.ideas2it.companymanagement.seatmanagement.dto.AllocationDto;

public class AllocationHelper {

    public static Allocation changeDtoToAllocationDetail(AllocationDto seatAllocationDto) {
        Allocation allocation = new Allocation();
        allocation.setSeatNumber(seatAllocationDto.getSeatNumber());
        //employee
        return allocation;
    }
    public static AllocationDto changeSeatAllocationToDto(Allocation allocationDetail) {
        if (allocationDetail != null) {
            AllocationDto allocationDto = new AllocationDto();
            allocationDto.setSeatNumber(allocationDetail.getSeatNumber());
            //employee
            return allocationDto;
        }
        return null;
    }
}
