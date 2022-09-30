package com.ideas2it.companymanagement.employeemanagement.controller;

import com.ideas2it.companymanagement.employeemanagement.dto.RoleDto;
import com.ideas2it.companymanagement.employeemanagement.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    /**
     * <p>
     * this method is to add Role details to database
     * </p>
     */
    @PostMapping
    public RoleDto insertRole(@RequestBody RoleDto roleDto){
        return roleService.addRole(roleDto);
    }

    /**
     * <p>
     * this method is to get Role By Id(primary key).
     * </p>
     */
    @GetMapping("/{id}")
    public RoleDto getRoleById (@PathVariable("id") int id){
        return roleService.getRoleDetailsById(id);
    }

    /**
     * <p>
     *  this method is to get all Role Details
     * </p>
     */
    @GetMapping
    public List<RoleDto> getAllRoles(){
        return roleService.getRoleDetails();
    }

    /**
     * <p>
     * this method is to add Role to database
     * </p>
     */
    @PutMapping
    public RoleDto updateRole(@RequestBody RoleDto roleDto){
        return roleService.updateRoleDetails(roleDto);
    }

    /**
     * <p>
     * this method is to delete Role Details
     * </p>
     */
    @DeleteMapping("/{id}")
    public boolean deleteRole(@PathVariable("id") int id){
        return  roleService.deleteRoleDetailsById(id);
    }
}
