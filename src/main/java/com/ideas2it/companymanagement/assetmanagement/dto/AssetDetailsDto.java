package com.ideas2it.companymanagement.assetmanagement.dto;

import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import lombok.Data;

@Data
public class AssetDetailsDto {

    private int id;
    private String assetName;
    private String serialNumber;
    private AssetTypeDto assetDto;
    private EmployeeDto employeeDto;

}
