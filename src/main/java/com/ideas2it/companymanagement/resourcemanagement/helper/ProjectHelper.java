package com.ideas2it.companymanagement.resourcemanagement.helper;


import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProjectHelper {

    public static ProjectDto projectToProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        if (project != null) {
            projectDto.setProjectName(project.getProjectName());
            if (projectDto.getId() != 0) {
                project.setId(projectDto.getId());
            }
            projectDto.setProjectDescription(project.getProjectDescription());
            Employee employee = project.getEmployee();
            if (employee != null) {
                EmployeeDto employeeDto = new EmployeeDto();
                employeeDto.setId(employee.getId());
                employeeDto.setEmployeeId(employee.getEmployeeId());
                employeeDto.setEmployeeName(employee.getEmployeeName());
                employeeDto.setDesignation(employee.getDesignation());
                employeeDto.setDateOfBirth(employee.getDateOfBirth());
                employeeDto.setGender(employee.getGender());
                employeeDto.setEmailId(employee.getEmailId());
                employeeDto.setPhoneNumber(employee.getPhoneNumber());
                employeeDto.setDateOfJoining(employee.getDateOfJoining());
                int experience = DateUtil.getYearBetweenDate(employee.getDateOfJoining());
                employeeDto.setExperience(experience);
                int age = DateUtil.getYearBetweenDate(employee.getDateOfBirth());
                employeeDto.setAge(age);
                employeeDto.setProjectDto(projectDto);
                projectDto.setEmployeeDto(employeeDto);
            }
            List<EmployeeDto> employeesDto = new ArrayList<>();
            List<Employee> employees = project.getEmployees();
            for (Employee employeeDetails : employees) {
                EmployeeDto employeeDto = new EmployeeDto();
                if (employee != null) {
                    if (employee.getId() != 0) {
                        employeeDto.setId(employeeDetails.getId());
                    }
                    employeeDto.setEmployeeId(employeeDetails.getEmployeeId());
                    employeeDto.setEmployeeName(employeeDetails.getEmployeeName());
                    employeeDto.setDesignation(employeeDetails.getDesignation());
                    employeeDto.setDateOfBirth(employeeDetails.getDateOfBirth());
                    employeeDto.setGender(employeeDetails.getGender());
                    employeeDto.setEmailId(employeeDetails.getEmailId());
                    employeeDto.setPhoneNumber(employeeDetails.getPhoneNumber());
                    employeeDto.setDateOfJoining(employeeDetails.getDateOfJoining());
                    int experience = DateUtil.getYearBetweenDate(employeeDetails.getDateOfJoining());
                    employeeDto.setExperience(experience);
                    int age = DateUtil.getYearBetweenDate(employeeDetails.getDateOfBirth());
                    employeeDto.setAge(age);
                    employeesDto.add(employeeDto);
                }
            }
            if (project.getId() != 0) {
                projectDto.setId(project.getId());
            }
            projectDto.setEmployeesDto(employeesDto);
        }
        return projectDto;
    }

    public static Project projectDtoToProject(ProjectDto projectDto) {
        Project project = new Project();
        if (projectDto != null) {
            project.setProjectName(projectDto.getProjectName());
            project.setProjectDescription(projectDto.getProjectDescription());
            EmployeeDto employeeDto = projectDto.getEmployeeDto();
            if (employeeDto != null) {
                Employee employee = new Employee();
                employee.setId(employeeDto.getId());
                employee.setEmployeeId(employeeDto.getEmployeeId());
                employee.setEmployeeName(employeeDto.getEmployeeName());
                employee.setDesignation(employeeDto.getDesignation());
                employee.setDateOfBirth(employeeDto.getDateOfBirth());
                employee.setGender(employeeDto.getGender());
                employee.setEmailId(employeeDto.getEmailId());
                employee.setDateOfJoining(employeeDto.getDateOfJoining());
                int experience = DateUtil.getYearBetweenDate(employeeDto.getDateOfJoining());
                employee.setExperience(experience);
                int age = DateUtil.getYearBetweenDate(employeeDto.getDateOfBirth());
                employee.setAge(age);
                employee.setProject(project);
                project.setEmployee(employee);
            }
            List<Employee> employees = new ArrayList<>();
            List<EmployeeDto> employeesDto = projectDto.getEmployeesDto();
            for (EmployeeDto employeeDtoDetails : employeesDto) {
                Employee employee = new Employee();
                if (employeeDto != null) {
                    employee.setId(employeeDto.getId());
                    employee.setEmployeeId(employeeDtoDetails.getEmployeeId());
                    employee.setEmployeeName(employeeDtoDetails.getEmployeeName());
                    employee.setDesignation(employeeDtoDetails.getDesignation());
                    employee.setDateOfBirth(employeeDtoDetails.getDateOfBirth());
                    employee.setGender(employeeDtoDetails.getGender());
                    employee.setEmailId(employeeDtoDetails.getEmailId());
                    employee.setPhoneNumber(employeeDtoDetails.getPhoneNumber());
                    employee.setDateOfJoining(employeeDtoDetails.getDateOfJoining());
                    int experience = DateUtil.getYearBetweenDate(employeeDtoDetails.getDateOfJoining());
                    employee.setExperience(experience);
                    int age = DateUtil.getYearBetweenDate(employeeDtoDetails.getDateOfBirth());
                    employee.setAge(age);
                    employees.add(employee);
                }
            }
            if (projectDto.getId() != 0) {
                project.setId(projectDto.getId());
            }
            project.setEmployees(employees);
        }
        return project;
    }
}
