package com.ideas2it.companymanagement.resourcemanagement.dto;

import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the project database table.
 */

@Data
public class ProjectDto {
    private int id;

    private String projectDescription;

    private String projectName;

    private EmployeeDto employeeDto;

    private List<EmployeeDto> employeesDto = new ArrayList<>();
}