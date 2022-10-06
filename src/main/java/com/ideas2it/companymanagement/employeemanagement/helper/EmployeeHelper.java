package com.ideas2it.companymanagement.employeemanagement.helper;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetTypeDto;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetType;
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

public class EmployeeHelper {
    public static Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        if (employeeDto != null) {
            employee.setEmployeeId(employeeDto.getEmployeeId());
            if (employeeDto.getId() != 0) {
                employee.setId(employeeDto.getId());
            }
            employee.setEmployeeName(employeeDto.getEmployeeName());
            employee.setDesignation(employeeDto.getDesignation());
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
            employee.setGender(employeeDto.getGender());
            employee.setEmailId(employeeDto.getEmailId());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
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
                seat.setEmployee(employee);
                employee.setSeat(seat);
            }

            List<AssetDetails> assetDetails = new ArrayList<>();
            List<AssetDetailsDto> assetDetailsDto = employeeDto.getAssetDetailsDto();
            if (assetDetailsDto != null) {
                for (AssetDetailsDto assetDetailDto : assetDetailsDto) {
                    AssetDetails assetDetail = new AssetDetails();
                    AssetTypeDto assetTypeDto = assetDetailDto.getAssetDto();
                    AssetType assetType = new AssetType();
                    assetType.setId(assetTypeDto.getId());
                    assetType.setAssetType(assetTypeDto.getAssetType());
                    assetDetail.setId(assetDetailDto.getId());
                    assetDetail.setAssetType(assetType);
                    assetDetail.setAssetName(assetDetailDto.getAssetName());
                    assetDetail.setSerialNumber(assetDetailDto.getSerialNumber());
                    assetDetail.setEmployee(employee);
                    assetDetails.add(assetDetail);

                }
                employee.setAssetDetails(assetDetails);
            }

            ProjectDto projectDto = employeeDto.getProjectDto();
            Project project = new Project();
            if (projectDto != null) {
                project.setId(projectDto.getId());
                project.setProjectName(projectDto.getProjectName());
                project.setProjectDescription(projectDto.getProjectDescription());
                if (projectDto.getEmployeeDto() != null) {
                    EmployeeDto currentEmployeeDto = projectDto.getEmployeeDto();
                    Employee currentEmployee = new Employee();
                    if (currentEmployeeDto.getId() != 0) {
                        currentEmployee.setId(currentEmployeeDto.getId());
                    }
                    currentEmployee.setEmployeeId(currentEmployeeDto.getEmployeeId());
                    currentEmployee.setEmployeeName(currentEmployeeDto.getEmployeeName());
                    currentEmployee.setDesignation(currentEmployeeDto.getDesignation());
                    currentEmployee.setDateOfBirth(currentEmployeeDto.getDateOfBirth());
                    currentEmployee.setGender(currentEmployeeDto.getGender());
                    currentEmployee.setEmailId(currentEmployeeDto.getEmailId());
                    currentEmployee.setPhoneNumber(currentEmployeeDto.getPhoneNumber());
                    currentEmployee.setDateOfJoining(currentEmployeeDto.getDateOfJoining());
                    experience = DateUtil.getYearBetweenDate(currentEmployeeDto.getDateOfJoining());
                    currentEmployee.setExperience(experience);
                    age = DateUtil.getYearBetweenDate(currentEmployeeDto.getDateOfBirth());
                    currentEmployee.setAge(age);
                    project.setEmployee(currentEmployee);
                }
                List<Employee> employees = project.getEmployees();
                List<EmployeeDto> employeesDto = projectDto.getEmployeesDto();
                for (EmployeeDto currentEmployeeDto : employeesDto) {
                    Employee currentEmployee = new Employee();
                    if (currentEmployeeDto.getId() != 0) {
                        currentEmployee.setId(currentEmployeeDto.getId());
                    }
                    currentEmployee.setEmployeeId(currentEmployeeDto.getEmployeeId());
                    currentEmployee.setEmployeeName(currentEmployeeDto.getEmployeeName());
                    currentEmployee.setDesignation(currentEmployeeDto.getDesignation());
                    currentEmployee.setDateOfBirth(currentEmployeeDto.getDateOfBirth());
                    currentEmployee.setGender(currentEmployeeDto.getGender());
                    currentEmployee.setEmailId(currentEmployeeDto.getEmailId());
                    currentEmployee.setPhoneNumber(currentEmployeeDto.getPhoneNumber());
                    currentEmployee.setDateOfJoining(currentEmployeeDto.getDateOfJoining());
                    experience = DateUtil.getYearBetweenDate(currentEmployeeDto.getDateOfJoining());
                    currentEmployee.setExperience(experience);
                    age = DateUtil.getYearBetweenDate(currentEmployeeDto.getDateOfBirth());
                    currentEmployee.setAge(age);
                    employees.add(currentEmployee);
                }
                employees.add(employee);
                employee.setProject(project);
            }

            RoleDto roleDto = employeeDto.getRoleDto();
            if (roleDto != null) {
                Role role = new Role();
                role.setId(roleDto.getId());
                role.setRole(roleDto.getRole());
                List<Employee> employees = role.getEmployees();
                List<EmployeeDto> employeesDto = roleDto.getEmployeesDto();
                for (EmployeeDto currentEmployeeDto : employeesDto) {
                    Employee currentEmployee = new Employee();
                    if (currentEmployeeDto.getId() != 0) {
                        currentEmployee.setId(currentEmployeeDto.getId());
                    }
                    currentEmployee.setEmployeeId(currentEmployeeDto.getEmployeeId());
                    currentEmployee.setEmployeeName(currentEmployeeDto.getEmployeeName());
                    currentEmployee.setDesignation(currentEmployeeDto.getDesignation());
                    currentEmployee.setDateOfBirth(currentEmployeeDto.getDateOfBirth());
                    currentEmployee.setGender(currentEmployeeDto.getGender());
                    currentEmployee.setEmailId(currentEmployeeDto.getEmailId());
                    currentEmployee.setPhoneNumber(currentEmployeeDto.getPhoneNumber());
                    currentEmployee.setDateOfJoining(currentEmployeeDto.getDateOfJoining());
                    experience = DateUtil.getYearBetweenDate(currentEmployeeDto.getDateOfJoining());
                    currentEmployee.setExperience(experience);
                    age = DateUtil.getYearBetweenDate(currentEmployeeDto.getDateOfBirth());
                    currentEmployee.setAge(age);
                    employees.add(currentEmployee);
                }
                employees.add(employee);
                employee.setRole(role);
            }
        }
        return employee;
    }

    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        if (employee != null) {
            if (employee.getId() != 0) {
                employeeDto.setId(employee.getId());
            }
            employeeDto.setEmployeeId(employee.getEmployeeId());
            employeeDto.setEmployeeName(employee.getEmployeeName());
            employeeDto.setDesignation(employee.getDesignation());
            employeeDto.setId(employee.getId());
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
            SeatDto seatDto = new SeatDto();

            List<AssetDetailsDto> assetDetailsDto = new ArrayList<>();
            List<AssetDetails> assetDetails = employee.getAssetDetails();
            for (AssetDetails assetDetail : assetDetails) {
                AssetDetailsDto assetDetailDto = new AssetDetailsDto();
                AssetType assetType = assetDetail.getAssetType();
                AssetTypeDto assetTypeDto = new AssetTypeDto();
                assetTypeDto.setId(assetType.getId());
                assetTypeDto.setAssetType(assetType.getAssetType());
                assetDetailDto.setAssetDto(assetTypeDto);
                assetDetailDto.setId(assetDetail.getId());
                assetDetailDto.setAssetName(assetDetail.getAssetName());
                assetDetailDto.setSerialNumber(assetDetail.getSerialNumber());
                assetTypeDto.setAssetDetailsDto(assetDetailDto);
                assetDetailsDto.add(assetDetailDto);
                assetDetailDto.setEmployeeDto(employeeDto);
            }
            employeeDto.setAssetDetailsDto(assetDetailsDto);

            Project project = employee.getProject();
            ProjectDto projectDto = new ProjectDto();
            if (project != null) {
                projectDto.setId(project.getId());
                projectDto.setProjectName(project.getProjectName());
                if (project.getEmployee() != null) {
                    Employee currentEmployee = project.getEmployee();
                    EmployeeDto currentEmployeeDto = new EmployeeDto();
                    if (currentEmployee.getId() != 0) {
                        currentEmployeeDto.setId(currentEmployee.getId());
                    }
                    currentEmployeeDto.setEmployeeId(currentEmployee.getEmployeeId());
                    currentEmployeeDto.setEmployeeName(currentEmployee.getEmployeeName());
                    currentEmployeeDto.setDesignation(currentEmployee.getDesignation());
                    currentEmployeeDto.setId(currentEmployee.getId());
                    currentEmployeeDto.setDateOfBirth(currentEmployee.getDateOfBirth());
                    currentEmployeeDto.setGender(currentEmployee.getGender());
                    currentEmployeeDto.setEmailId(currentEmployee.getEmailId());
                    currentEmployeeDto.setPhoneNumber(currentEmployee.getPhoneNumber());
                    currentEmployeeDto.setDateOfJoining(currentEmployee.getDateOfJoining());
                    experience = DateUtil.getYearBetweenDate(currentEmployee.getDateOfJoining());
                    currentEmployeeDto.setExperience(experience);
                    age = DateUtil.getYearBetweenDate(currentEmployee.getDateOfBirth());
                    currentEmployeeDto.setAge(age);
                    projectDto.setEmployeeDto(currentEmployeeDto);
                }
                projectDto.setProjectDescription(project.getProjectDescription());
                List<Employee> employees = project.getEmployees();
                List<EmployeeDto> employeesDto = projectDto.getEmployeesDto();
                for (Employee currentEmployee : employees) {
                    EmployeeDto currentEmployeeDto = new EmployeeDto();
                    if (currentEmployee.getId() != 0) {
                        currentEmployeeDto.setId(currentEmployee.getId());
                    }
                    currentEmployeeDto.setEmployeeId(currentEmployee.getEmployeeId());
                    currentEmployeeDto.setEmployeeName(currentEmployee.getEmployeeName());
                    currentEmployeeDto.setDesignation(currentEmployee.getDesignation());
                    currentEmployeeDto.setId(currentEmployee.getId());
                    currentEmployeeDto.setDateOfBirth(currentEmployee.getDateOfBirth());
                    currentEmployeeDto.setGender(currentEmployee.getGender());
                    currentEmployeeDto.setEmailId(currentEmployee.getEmailId());
                    currentEmployeeDto.setPhoneNumber(currentEmployee.getPhoneNumber());
                    currentEmployeeDto.setDateOfJoining(currentEmployee.getDateOfJoining());
                    experience = DateUtil.getYearBetweenDate(currentEmployee.getDateOfJoining());
                    currentEmployeeDto.setExperience(experience);
                    age = DateUtil.getYearBetweenDate(currentEmployee.getDateOfBirth());
                    currentEmployeeDto.setAge(age);
                    employeesDto.add(currentEmployeeDto);
                }
                employeesDto.add(employeeDto);
                employeeDto.setProjectDto(projectDto);

            }

            Role role = employee.getRole();
            if (role != null) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setRole(role.getRole());

                List<Employee> employees = role.getEmployees();
                List<EmployeeDto> employeesDto = roleDto.getEmployeesDto();
                for (Employee currentEmployee : employees) {
                    EmployeeDto currentEmployeeDto = new EmployeeDto();
                    if (currentEmployee.getId() != 0) {
                        currentEmployeeDto.setId(currentEmployee.getId());
                    }
                    currentEmployeeDto.setEmployeeId(currentEmployee.getEmployeeId());
                    currentEmployeeDto.setEmployeeName(currentEmployee.getEmployeeName());
                    currentEmployeeDto.setDesignation(currentEmployee.getDesignation());
                    currentEmployeeDto.setId(currentEmployee.getId());
                    currentEmployeeDto.setDateOfBirth(currentEmployee.getDateOfBirth());
                    currentEmployeeDto.setGender(currentEmployee.getGender());
                    currentEmployeeDto.setEmailId(currentEmployee.getEmailId());
                    currentEmployeeDto.setPhoneNumber(currentEmployee.getPhoneNumber());
                    currentEmployeeDto.setDateOfJoining(currentEmployee.getDateOfJoining());
                    experience = DateUtil.getYearBetweenDate(currentEmployee.getDateOfJoining());
                    currentEmployeeDto.setExperience(experience);
                    age = DateUtil.getYearBetweenDate(currentEmployee.getDateOfBirth());
                    currentEmployeeDto.setAge(age);
                    employeesDto.add(currentEmployeeDto);

                }
                employeesDto.add(employeeDto);
                employeeDto.setRoleDto(roleDto);
            }
            if (employee.getId() != 0) {
                employeeDto.setId(employee.getId());
            }

            if (seat != null) {
                seatDto.setId(seat.getId());
                seatDto.setSeatNumber(seat.getSeatNumber());
                seatDto.setEmployeeDto(employeeDto);
                employeeDto.setSeatDto(seatDto);
            }
        }
        return employeeDto;
    }
}
