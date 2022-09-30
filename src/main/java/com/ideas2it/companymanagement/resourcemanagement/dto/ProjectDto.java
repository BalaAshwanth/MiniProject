package com.ideas2it.companymanagement.resourcemanagement.dto;

import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;

import java.util.List;
import java.util.ArrayList;

/**
 * The persistent class for the project database table.
 *
 */

public class ProjectDto {
    private int id;

    private String projectDescription;

    private String projectName;

    private EmployeeDto employee;

    private List<EmployeeDto> employees = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}