package com.ideas2it.companymanagement.assetmanagement.controller;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetTypeDto;
import com.ideas2it.companymanagement.assetmanagement.service.AssetService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * Controller that handles the CRUD Operations.
 * </p>
 */
@RestController
@RequestMapping("/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    /**
     * <p>
     * Searches and retrieves asset based on the given id
     * </p>
     *
     * @param id
     * @return AssetTypeDto.
     *
     */
    @GetMapping("/{assetId}")
    private AssetTypeDto getAsset(@PathVariable("assetId") int id) {
        return assetService.getAsset(id);
    }

    /**
     * <p>
     * Creates new asset and sends to Asset service
     * </p>
     *
     * @param assetDto
     * @return AssetTypeDto.
     */
    @PostMapping
    private AssetTypeDto insertAsset(AssetTypeDto assetDto) {
        return assetService.setAsset(assetDto);
    }

    /**
     * <p>
     * Initiates the process of updating asset.
     * </p>
     *
     * @param assetDto
     * @return AssetTypeDto
     */
    @PutMapping
    private AssetTypeDto updateAsset(AssetTypeDto assetDto) {
        return assetService.updateAsset(assetDto);
    }

    /**
     * <p>
     * Searches and deletes asset based on the given id.
     * </p>
     *
     * @param id
     * @return boolean
     *
     */
    @DeleteMapping("/{assetId}")
    private Boolean deleteAsset(@PathVariable("assetId") int id) {
        return assetService.deleteAsset(id);
    }

    /**
     * <p>
     * retrieves all assets.
     * </p>
     *
     * @return List<AssetTypeDto>
     *
     */
    @GetMapping private List<AssetTypeDto> getAllAssets() {
        return assetService.getAllAsset();
    }
}
