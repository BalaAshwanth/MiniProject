package com.ideas2it.companymanagement.assetmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ideas2it.companymanagement.employeemanagement.dto.EmployeeDto;
import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AssetDetailsDto {
    private int id;
    private String assetName;
    private String serialNumber;
    private AssetTypeDto assetDto;
    private EmployeeDto employeeDto;

}
