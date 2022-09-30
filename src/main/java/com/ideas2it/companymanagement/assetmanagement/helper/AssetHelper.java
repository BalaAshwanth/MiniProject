package com.ideas2it.companymanagement.assetmanagement.helper;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetTypeDto;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetType;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;

public class AssetHelper {

    public static AssetType assetDtoToAsset(AssetTypeDto assetTypeDto) {
        AssetType assetType = new AssetType();
        assetType.setAssetType(assetTypeDto.getAssetType());
        assetType.setAssetDetails(assetDetailsDtoToAssetDetails(assetTypeDto.getAssetDetailsDto()));
        return assetType;
    }

    public static AssetTypeDto assetToAssetDto(AssetType assetType) {
        if (assetType != null) {
            AssetTypeDto assetTypeDto = new AssetTypeDto();
            assetTypeDto.setAssetType(assetType.getAssetType());
            assetTypeDto.setAssetDetailsDto(assetDetailsToAssetDetailsDto(assetType.getAssetDetails()));
            return assetTypeDto;
        }
        return null;
    }

    public static AssetDetails assetDetailsDtoToAssetDetails(AssetDetailsDto assetDetailsDto) {
        AssetDetails assetDetails = new AssetDetails();
        assetDetails.setAssetName(assetDetailsDto.getAssetName());
        assetDetails.setSerialNumber(assetDetailsDto.getSerialNumber());
        assetDetails.setAssetType(assetDtoToAsset(assetDetailsDto.getAssetDto()));
        //Need Employee object
        return assetDetails;
    }

    public static AssetDetailsDto assetDetailsToAssetDetailsDto(AssetDetails assetDetails) {
        if (assetDetails != null) {
            AssetDetailsDto assetDetailsDto = new AssetDetailsDto();
            assetDetailsDto.setAssetName(assetDetails.getAssetName());
            assetDetailsDto.setSerialNumber(assetDetails.getSerialNumber());
            assetDetailsDto.setAssetDto(assetToAssetDto(assetDetails.getAssetType()));
            //Need Employee object
            return assetDetailsDto;
        }
        return null;
    }
}
