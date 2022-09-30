package com.ideas2it.companymanagement.employeemanagement.helper;

import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import com.ideas2it.companymanagement.employeemanagement.entity.Employee;

public class EmployeeHelper {
    public static Employee employeeDtoToEmployee(EmployeeDto employeeDto){
       Employee employee = new Employee();
       employee.setEmployeeId(employeeDto.getEmployeeId());
       employee.setEmployeeName(employeeDto.getEmployeeName());
       employee.setDesignation(employeeDto.getDesignation());
       employee.setDateOfBirth(employeeDto.getDateOfBirth());
       employee.setGender(employeeDto.getGender());
       employee.setEmailId(employeeDto.getEmailId());
       employee.setPhoneNumber(employeeDto.getPhoneNumber());
       employee.setExperience(employeeDto.getExperience());
       employee.setDateOfJoining(employeeDto.getDateOfJoining());
       return employee;
    }

    public static EmployeeDto employeeToEmployeeDto(Employee employee){
        if (employee != null) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEmployeeId(employee.getEmployeeId());
            employeeDto.setEmployeeName(employee.getEmployeeName());
            employeeDto.setDesignation(employee.getDesignation());
            employeeDto.setDateOfBirth(employee.getDateOfBirth());
            employeeDto.setGender(employee.getGender());
            employeeDto.setEmailId(employee.getEmailId());
            employeeDto.setPhoneNumber(employee.getPhoneNumber());
            employeeDto.setExperience(employee.getExperience());
            employeeDto.setDateOfJoining(employee.getDateOfJoining());
            return employeeDto;
        }
        return null;
    }
}
