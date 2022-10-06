package com.ideas2it.companymanagement.assetmanagement.helper;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetTypeDto;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetType;
import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import com.ideas2it.companymanagement.employeemanagement.helper.EmployeeHelper;
import com.ideas2it.companymanagement.util.DateUtil;

public class AssetHelper {

    public static AssetType assetDtoToAsset(AssetTypeDto assetTypeDto) {
        AssetType assetType = new AssetType();
        if (assetTypeDto != null) {
            assetType.setAssetType(assetTypeDto.getAssetType());
            if (assetTypeDto.getId() != 0) {
                assetType.setId(assetTypeDto.getId());
            }
        }

        return assetType;
    }

    public static AssetTypeDto assetToAssetDto(AssetType assetType) {
        AssetTypeDto assetTypeDto = new AssetTypeDto();
        if (assetType != null) {
            assetTypeDto.setAssetType(assetType.getAssetType());
            if (assetType.getId() != 0) {
                assetTypeDto.setId(assetType.getId());
            }
            if (assetType.getId() != 0) {
                assetTypeDto.setId(assetType.getId());
            }
        }
        return assetTypeDto;
    }

    public static AssetDetails assetDetailsDtoToAssetDetails(AssetDetailsDto assetDetailsDto) {
        AssetDetails assetDetails = new AssetDetails();
        if (assetDetailsDto != null) {
            assetDetails.setId(assetDetailsDto.getId());
            assetDetails.setAssetName(assetDetailsDto.getAssetName());
            assetDetails.setSerialNumber(assetDetailsDto.getSerialNumber());
            AssetTypeDto assetTypeDto = assetDetailsDto.getAssetDto();
            AssetType assetType = new AssetType();
            assetType.setId(assetTypeDto.getId());
            assetType.setAssetType(assetTypeDto.getAssetType());
            assetDetails.setAssetType(assetType);
            EmployeeDto employeeDto = assetDetailsDto.getEmployeeDto();
            if (employeeDto != null) {
                Employee employee = new Employee();
                employee.setEmployeeId(employeeDto.getEmployeeId());
                employee.setEmployeeName(employeeDto.getEmployeeName());
                employee.setId(employeeDto.getId());
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
                assetDetails.setEmployee(employee);
            }
            if (assetDetailsDto.getId() != 0) {
                assetDetails.setId(assetDetailsDto.getId());
            }
        }
        return assetDetails;
    }

    public static AssetDetailsDto assetDetailsToAssetDetailsDto(AssetDetails assetDetails) {
        AssetDetailsDto assetDetailsDto = new AssetDetailsDto();
        if (assetDetails != null) {
            assetDetailsDto.setId(assetDetails.getId());
            assetDetailsDto.setAssetName(assetDetails.getAssetName());
            assetDetailsDto.setSerialNumber(assetDetails.getSerialNumber());
            AssetType assetType = assetDetails.getAssetType();
            if (assetType != null) {
                AssetTypeDto assetTypeDto = new AssetTypeDto();
                assetTypeDto.setId(assetType.getId());
                assetTypeDto.setAssetType(assetType.getAssetType());
                assetDetailsDto.setAssetDto(assetTypeDto);
                Employee employee = assetDetails.getEmployee();
                if (employee != null) {
                    EmployeeDto employeeDto = new EmployeeDto();
                    employeeDto.setEmployeeId(employee.getEmployeeId());
                    employeeDto.setEmployeeName(employee.getEmployeeName());
                    employeeDto.setId(employee.getId());
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
                    assetDetailsDto.setEmployeeDto(employeeDto);
                }
            }
        }
        return assetDetailsDto;
    }
}