package com.ideas2it.companymanagement.employeemanagement.service.impl;

import com.ideas2it.companymanagement.employeemanagement.dto.RoleDto;
import com.ideas2it.companymanagement.employeemanagement.helper.RoleHelper;
import com.ideas2it.companymanagement.employeemanagement.entity.Role;
import com.ideas2it.companymanagement.employeemanagement.repository.RoleRepository;
import com.ideas2it.companymanagement.employeemanagement.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * <p>
     * This method is used to set RoleDto objects to Role.
     * </p>
     */
    public RoleDto addRole(RoleDto roleDto) {
        return RoleHelper.roleToRoleDto(roleRepository.save(RoleHelper.roleDtoToRole(roleDto)));
    }

    /**
     * <p>
     * This method is used to get all Role details from database.
     * </p>
     */
    public List<RoleDto> getRoleDetails() {
        final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);
        List<Role> employees = roleRepository.findAll();
        if (employees.isEmpty()) {
            LOG.info("There is no Role Details Present");
        }
        return employees.stream().
                map(employee -> RoleHelper.roleToRoleDto(employee)
                ).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method is used to get a Role details by Id(primary key in database)
     * </p>
     */
    public RoleDto getRoleDetailsById(int id) {
        RoleDto roleDto = null;
        Optional<Role> employee = roleRepository.findById(id);
        if (employee.isPresent()) {
            roleDto = RoleHelper.roleToRoleDto(employee.get());
        }
        return roleDto;
    }

    /**
     * <p>
     * This method is used to delete a Role details by Id(primary key in database)
     * </p>
     */
    public boolean deleteRoleDetailsById(int id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * This method is used to update Role details
     * </p>
     */
    public RoleDto updateRoleDetails(RoleDto roleDto) {
        return RoleHelper.roleToRoleDto(roleRepository.save(RoleHelper.roleDtoToRole(roleDto)));
    }

}
