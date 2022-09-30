package com.ideas2it.companymanagement.employeemanagement.dto;

import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;
import com.ideas2it.companymanagement.employeemanagement.entity.Role;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.seatmanagement.entity.Allocation;
import lombok.Data;

import java.time.LocalDate;

@Data
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
    private Allocation seat;
    private AssetDetails assetDetails;
    private Project project;
    private Role role;
}