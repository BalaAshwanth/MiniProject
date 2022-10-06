package com.ideas2it.companymanagement.assetmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AssetTypeDto {
    private int id;
    private String assetType;
    private AssetDetailsDto assetDetailsDto;

}
