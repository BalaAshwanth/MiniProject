package com.ideas2it.companymanagement.seatmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SeatDto {
    private int id;
    private String seatNumber;
    private EmployeeDto employeeDto;

}

