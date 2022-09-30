package com.ideas2it.companymanagement.seatmanagement.dto;

import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import lombok.Data;

@Data
public class AllocationDto {
    private int id;
    private String seatNumber;
    private Employee employee;

    public AllocationDto(int id, String seatNumber, Employee employee) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.employee = employee;
    }

    public AllocationDto() {
    }
}

