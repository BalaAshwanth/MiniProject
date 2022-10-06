package com.ideas2it.companymanagement.seatmanagement.helper;

import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import com.ideas2it.companymanagement.employeemanagement.helper.RoleHelper;
import com.ideas2it.companymanagement.resourcemanagement.helper.ProjectHelper;
import com.ideas2it.companymanagement.seatmanagement.dto.SeatDto;
import com.ideas2it.companymanagement.seatmanagement.entity.Seat;
import com.ideas2it.companymanagement.util.DateUtil;

public class SeatHelper {

    public static Seat changeDtoToAllocationDetail(SeatDto seatDto) {
        Seat seat = new Seat();
        if (seatDto != null) {
            seat.setSeatNumber(seatDto.getSeatNumber());
            EmployeeDto employeeDto = seatDto.getEmployeeDto();
            if (employeeDto != null) {
                Employee employee = new Employee();
                employee.setId(employeeDto.getId());
                employee.setEmployeeId(employeeDto.getEmployeeId());
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
                seat.setEmployee(employee);
            }
            if (seatDto.getId() != 0) {
                seat.setId(seatDto.getId());
            }
        }
        return seat;
    }

    public static SeatDto changeSeatAllocationToDto(Seat seat) {
        SeatDto seatDto = new SeatDto();
        if (seat != null) {
            seatDto.setSeatNumber(seat.getSeatNumber());
            if (seat.getId() != 0) {
                seatDto.setId(seat.getId());
            }
            Employee employee = seat.getEmployee();
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
                employeeDto.setSeatDto(seatDto);
                employeeDto.setProjectDto(ProjectHelper.projectToProjectDto(employee.getProject()));
                employeeDto.setRoleDto(RoleHelper.roleToRoleDto(employee.getRole()));
                seatDto.setEmployeeDto(employeeDto);
            }
        }
        return seatDto;
    }
}
