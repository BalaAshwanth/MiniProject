package com.ideas2it.companymanagement.assetmanagement.service.impl;

import com.ideas2it.companymanagement.assetmanagement.dao.AssetRepo;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetTypeDto;
import com.ideas2it.companymanagement.assetmanagement.helper.AssetHelper;
import com.ideas2it.companymanagement.assetmanagement.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Implementation for handling all business logics of asset model.
 * </p>
 */
@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepo assetRepo;

    public AssetServiceImpl(AssetRepo assetRepo) {
        this.assetRepo = assetRepo;
    }

    /**
     * <p>
     * This method is used to set asset dto objects to asset detail.
     * </p>
     *
     * @param assetDto
     *
     * @return AssetTypeDto.
     */
    @Override
    public AssetTypeDto setAsset(AssetTypeDto assetDto) {
        return AssetHelper.assetToAssetDto(assetRepo.save(AssetHelper.assetDtoToAsset(assetDto)));
    }

    /**
     * <p>
     * Retrieves asset from repository by id.
     * </p>
     *
     * @param id
     *
     * @return AssetTypeDto.
     *
     */
    @Override
    public AssetTypeDto getAsset(int id) {
        return AssetHelper.assetToAssetDto(assetRepo.findById(id).orElse(null));
    }

    /**
     * <p>
     * Deletes asset by id.
     * </p>
     *
     * @param id
     *
     * @return boolean
     *
     */
    @Override
    public boolean deleteAsset(int id) {
        if (assetRepo.existsById(id)) {
            assetRepo.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * This is to updates the asset.
     * </p>
     *
     * @param assetDto
     *
     * @return AssetTypeDto
     *
     */
    @Override
    public AssetTypeDto updateAsset(AssetTypeDto assetDto) {
        return AssetHelper.assetToAssetDto(assetRepo.save(AssetHelper.assetDtoToAsset(assetDto)));
    }

    /**
     * <p>
     * Retrieves all asset from the database.
     * </p>
     *
     * @return List<AssetTypeDto>
     */
    @Override
    public List<AssetTypeDto> getAllAsset() {
        return assetRepo.findAll().stream().map(AssetHelper::assetToAssetDto).collect(Collectors.toList());
    }

}
