package com.ideas2it.companymanagement.assetmanagement.service;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;

import java.util.List;

public interface AssetDetailService {

    AssetDetailsDto setAssertDetails(AssetDetailsDto assetDetailsDto);

    AssetDetailsDto getAssetDetails(int id);

    boolean deleteAssetDetails(int id) ;

    AssetDetailsDto updateAssetDetails(AssetDetailsDto assetDetailsDto);

    List<AssetDetailsDto> getAllAssetDetails();
}
