package com.ideas2it.companymanagement.resourcemanagement.helper;


import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import com.ideas2it.companymanagement.employeemanagement.dto.RoleDto;
import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import com.ideas2it.companymanagement.employeemanagement.entity.Role;
import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.seatmanagement.dto.SeatDto;
import com.ideas2it.companymanagement.seatmanagement.entity.Seat;
import com.ideas2it.companymanagement.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProjectHelper {

    public static ProjectDto projectToProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        if (project != null) {
            if (project.getId() != 0) {
                projectDto.setId(project.getId());
            }
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
                Seat seat = employee.getSeat();
                if (seat != null) {
                    SeatDto seatDto = new SeatDto();
                    seatDto.setId(seat.getId());
                    seatDto.setSeatNumber(seat.getSeatNumber());
                    employeeDto.setSeatDto(seatDto);
                }
                Role role = employee.getRole();
                if (role != null) {
                    RoleDto roleDto = new RoleDto();
                    roleDto.setId(role.getId());
                    roleDto.setRole(role.getRole());
                    employeeDto.setRoleDto(roleDto);
                }
                Project projectDetails = employee.getProject();
                if(projectDetails != null) {
                    projectDto = new ProjectDto();
                    projectDto.setId(projectDetails.getId());
                    projectDto.setProjectName(projectDetails.getProjectName());
                    projectDto.setProjectDescription(projectDetails.getProjectDescription());
                    employeeDto.setProjectDto(projectDto);
                }
                projectDto.setEmployeeDto(employeeDto);
            }
            List<EmployeeDto> employeesDto = new ArrayList<>();
            List<Employee> employees = project.getEmployees();
            for (Employee employeeDetails : employees) {
                EmployeeDto employeeDto = new EmployeeDto();
                if (employeeDetails != null) {
                    if (employeeDetails.getId() != 0) {
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
                    Seat seatDetails = employeeDetails.getSeat();
                    if (seatDetails != null) {
                        SeatDto seatDtoDetails = new SeatDto();
                        seatDtoDetails.setId(seatDetails.getId());
                        seatDtoDetails.setSeatNumber(seatDetails.getSeatNumber());
                        employeeDto.setSeatDto(seatDtoDetails);
                    }
                    Role roleDetails = employeeDetails.getRole();
                    if (roleDetails != null) {
                        RoleDto roleDtoDetails = new RoleDto();
                        roleDtoDetails.setId(roleDetails.getId());
                        roleDtoDetails.setRole(roleDetails.getRole());
                        employeeDto.setRoleDto(roleDtoDetails);
                    }
                    Project projectDetails = employeeDetails.getProject();
                    if(projectDetails != null) {
                        ProjectDto projectDtoDetails = new ProjectDto();
                        projectDtoDetails.setId(projectDetails.getId());
                        projectDtoDetails.setProjectName(projectDetails.getProjectName());
                        projectDtoDetails.setProjectDescription(projectDetails.getProjectDescription());
                        employeeDto.setProjectDto(projectDtoDetails);
                    }
                    employeesDto.add(employeeDto);
                }
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
            if (projectDto.getId() != 0) {
                project.setId(projectDto.getId());
            }
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
                SeatDto seatDto = employeeDto.getSeatDto();
                if (seatDto != null) {
                    Seat seat = new Seat();
                    seat.setId(seatDto.getId());
                    seat.setSeatNumber(seatDto.getSeatNumber());
                    employee.setSeat(seat);
                }
                RoleDto roleDto = employeeDto.getRoleDto();
                if (roleDto != null) {
                    Role role = new Role();
                    role.setId(roleDto.getId());
                    role.setRole(roleDto.getRole());
                    employee.setRole(role);
                }
                ProjectDto projectDtoDetails = employeeDto.getProjectDto();
                if(projectDtoDetails != null) {
                    project = new Project();
                    project.setId(projectDtoDetails.getId());
                    project.setProjectName(projectDtoDetails.getProjectName());
                    project.setProjectDescription(projectDtoDetails.getProjectDescription());
                    employee.setProject(project);
                }
                project.setEmployee(employee);
            }
            List<Employee> employees = new ArrayList<>();
            List<EmployeeDto> employeesDto = projectDto.getEmployeesDto();
            for (EmployeeDto employeeDtoDetails : employeesDto) {
                Employee employee = new Employee();
                if (employeeDtoDetails != null) {
                    employee.setId(employeeDtoDetails.getId());
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
                    SeatDto seatDtoDetails = employeeDtoDetails.getSeatDto();
                    if (seatDtoDetails != null) {
                        Seat seatDetails = new Seat();
                        seatDetails.setId(seatDtoDetails.getId());
                        seatDetails.setSeatNumber(seatDtoDetails.getSeatNumber());
                        employee.setSeat(seatDetails);
                    }
                    RoleDto roleDtoDetails = employeeDtoDetails.getRoleDto();
                    if (roleDtoDetails != null) {
                        Role roleDetails = new Role();
                        roleDetails.setId(roleDtoDetails.getId());
                        roleDetails.setRole(roleDtoDetails.getRole());
                        employee.setRole(roleDetails);
                    }
                    ProjectDto projectDtoDetails = employeeDtoDetails.getProjectDto();
                    if(projectDtoDetails != null) {
                        Project projectDetails = new Project();
                        projectDetails.setId(projectDtoDetails.getId());
                        projectDetails.setProjectName(projectDtoDetails.getProjectName());
                        projectDetails.setProjectDescription(projectDtoDetails.getProjectDescription());
                        employee.setProject(projectDetails);
                    }
                    employees.add(employee);
                }
            }
            project.setEmployees(employees);
        }
        return project;
    }
}
