package com.ideas2it.companymanagement.employeemanagement.controller;

import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import com.ideas2it.companymanagement.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    /**
     * <p>
     * this method is to add Employee details to database
     * </p>
     */
    @PostMapping
    public EmployeeDto insertEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);
    }

    /**
     * <p>
     * this method is to get Employee By Id(primary key).
     * </p>
     */
    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById (@PathVariable("id") int id){
        return employeeService.getEmployeeDetailsById(id);
    }

    /**
     * <p>
     *  this method is to get all Employee Details
     * </p>
     */
    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getEmployeeDetails();
    }

    /**
     * <p>
     * this method is to add Employee to database
     * </p>
     */
    @PutMapping
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployeeDetails(employeeDto);
    }

    /**
     * <p>
     * this method is to delete Employee Details
     * </p>
     */
    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable("id") int id) {
        return (employeeService.deleteEmployeeDetailsById(id));
    }
}