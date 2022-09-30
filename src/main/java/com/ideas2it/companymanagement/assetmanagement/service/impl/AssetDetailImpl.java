package com.ideas2it.companymanagement.assetmanagement.service.impl;

import com.ideas2it.companymanagement.assetmanagement.dao.AssetDetailRepo;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.helper.AssetHelper;
import com.ideas2it.companymanagement.assetmanagement.service.AssetDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetDetailImpl implements AssetDetailService {

    private final AssetDetailRepo assetDetailRepo;

    public AssetDetailImpl(AssetDetailRepo assetDetailRepo) {
        this.assetDetailRepo = assetDetailRepo;
    }

    @Override
    public AssetDetailsDto setAssertDetails(AssetDetailsDto assetDetailsDto) {
        return AssetHelper.assetDetailsToAssetDetailsDto(assetDetailRepo.save(AssetHelper.assetDetailsDtoToAssetDetails(assetDetailsDto)));
    }

    @Override
    public AssetDetailsDto getAssetDetails(int id) {
        return AssetHelper.assetDetailsToAssetDetailsDto(assetDetailRepo.findById(id).orElse(null));
    }

    @Override
    public boolean deleteAssetDetails(int id) {
        if (assetDetailRepo.existsById(id)) {
            assetDetailRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public AssetDetailsDto updateAssetDetails(AssetDetailsDto assetDetailsDto) {
        return AssetHelper.assetDetailsToAssetDetailsDto(assetDetailRepo.save(AssetHelper.assetDetailsDtoToAssetDetails(assetDetailsDto)));
    }

    @Override
    public List<AssetDetailsDto> getAllAssetDetails() {
        return assetDetailRepo.findAll().stream().map(AssetHelper::assetDetailsToAssetDetailsDto).collect(Collectors.toList());
    }
}
