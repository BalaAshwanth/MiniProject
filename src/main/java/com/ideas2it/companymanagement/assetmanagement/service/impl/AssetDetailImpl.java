package com.ideas2it.companymanagement.assetmanagement.service.impl;

import com.ideas2it.companymanagement.assetmanagement.dao.AssetDetailRepo;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.helper.AssetHelper;
import com.ideas2it.companymanagement.assetmanagement.service.AssetDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Implementation for handling all business logics of asset model
 * </p>
 */
@Service
public class AssetDetailImpl implements AssetDetailService {

    private final AssetDetailRepo assetDetailRepo;

    public AssetDetailImpl(AssetDetailRepo assetDetailRepo) {
        this.assetDetailRepo = assetDetailRepo;
    }

    /**
     * <p>
     * This method is used to set asset detail dto objects to asset detail.
     * </p>
     *
     * @param assetDetailsDto
     * @return AssetDetailDto
     */
    @Override
    public AssetDetailsDto setAssertDetails(AssetDetailsDto assetDetailsDto) {
        return AssetHelper.assetDetailsToAssetDetailsDto(assetDetailRepo.save(AssetHelper.assetDetailsDtoToAssetDetails(assetDetailsDto)));
    }

    /**
     * <p>
     * Retrieves asset detail from repository by id.
     * </p>
     *
     * @param id
     * @return AssetDetailDto
     *
     */
    @Override
    public AssetDetailsDto getAssetDetails(int id) {
        return AssetHelper.assetDetailsToAssetDetailsDto(assetDetailRepo.findById(id).orElse(null));
    }

    /**
     * <p>
     * Deletes asset detail by id.
     * </p>
     *
     * @param id
     * @return boolean
     *
     */
    @Override
    public boolean deleteAssetDetails(int id) {
        if (assetDetailRepo.existsById(id)) {
            assetDetailRepo.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * This is to updates the asset detail
     * </p>
     *
     * @param assetDetailsDto
     * @return AssetDetailsDto
     *
     */
    @Override
    public AssetDetailsDto updateAssetDetails(AssetDetailsDto assetDetailsDto) {
        return AssetHelper.assetDetailsToAssetDetailsDto(assetDetailRepo.save(AssetHelper.assetDetailsDtoToAssetDetails(assetDetailsDto)));
    }

    /**
     * <p>
     * Retrieves all asset detail from the database.
     * </p>
     *
     * @return List<AssetDetailsDto>
     */
    @Override
    public List<AssetDetailsDto> getAllAssetDetails() {
        return assetDetailRepo.findAll().stream().map(AssetHelper::assetDetailsToAssetDetailsDto).collect(Collectors.toList());
    }
}
