package com.ideas2it.companymanagement.employeemanagement.dto;

import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import lombok.Data;

@Data
public class RoleDto {
    private int id;
    private String role;
    private Employee employee;
}
