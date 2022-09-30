package com.ideas2it.companymanagement.employeemanagement.helper;

import com.ideas2it.companymanagement.employeemanagement.dto.RoleDto;
import com.ideas2it.companymanagement.employeemanagement.entity.Role;

public class RoleHelper {
    public static Role roleDtoToRole(RoleDto roleDto){
        Role role = new Role();
        role.setRole(roleDto.getRole());
        return role;
    }

    public static RoleDto roleToRoleDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setRole(role.getRole());
        return roleDto;
    }
}
