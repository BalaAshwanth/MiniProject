package com.ideas2it.companymanagement.employeemanagement.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.seatmanagement.dto.SeatDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EmployeeDto {

    private int id;
    private String employeeId;
    private String employeeName;
    private String gender;
    private LocalDate dateOfBirth;
    private Long phoneNumber;
    private String emailId;
    private String designation;
    private LocalDate dateOfJoining;
    private int experience;
    private int Age;
    private SeatDto seatDto;
    private List<AssetDetailsDto> assetDetailsDto = new ArrayList<>();
    private ProjectDto projectDto;
    private RoleDto roleDto;

}