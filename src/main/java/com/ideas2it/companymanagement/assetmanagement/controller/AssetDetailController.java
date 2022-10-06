package com.ideas2it.companymanagement.assetmanagement.controller;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.service.AssetDetailService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * Controller that handles the CRUD Operations.
 * </p>
 */
@RestController
@RequestMapping("/assetInfo")
public class AssetDetailController {

    private final AssetDetailService assetDetailService;

    public AssetDetailController(AssetDetailService assetDetailService) {
        this.assetDetailService = assetDetailService;
    }

    /**
     * <p>
     * Creates new asset and sends to Asset service
     * </p>
     *
     * @param assetDetailsDto
     * @return AssetDetailsDto
     */
    @PostMapping
    private AssetDetailsDto insertAssetDetails(@RequestBody AssetDetailsDto assetDetailsDto) {
        return assetDetailService.setAssertDetails(assetDetailsDto);
    }

    /**
     * <p>
     * Searches and retrieves asset details based on the given id
     * </p>
     *
     * @param id
     * @return AssetDetailsDto
     *
     */
    @GetMapping("/{assetInfoId}")
    private AssetDetailsDto getAssetDetails(@PathVariable("assetInfoId") int id) {
        return assetDetailService.getAssetDetails(id);
    }

    /**
     * <p>
     * Initiates the process of updating asset details.
     * </p>
     *
     * @param assetDetailsDto
     * @return AssetDetailsDto
     */
    @PutMapping
    private AssetDetailsDto updateAssetDetails(@RequestBody AssetDetailsDto assetDetailsDto) {
        return assetDetailService.updateAssetDetails(assetDetailsDto);
    }

    /**
     * <p>
     * Searches and deletes asset details based on the given id.
     * </p>
     *
     * @param id
     * @return boolean
     *
     */
    @DeleteMapping("/{assetInfoId}")
    private boolean deleteAssetDetails(@PathVariable("assetInfoId") int id) {
        return assetDetailService.deleteAssetDetails(id);
    }

    /**
     * <p>
     * retrieves all asset details.
     * </p>
     *
     * @return List<AssetDetailsDto>
     *
     */
    @GetMapping
    private List<AssetDetailsDto> getAllAssetDetails() {
        return assetDetailService.getAllAssetDetails();
    }
}
