package com.ideas2it.companymanagement.assetmanagement.controller;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetTypeDto;
import com.ideas2it.companymanagement.assetmanagement.service.AssetService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/{assetId}")
    private AssetTypeDto getAsset(@PathVariable("assetId") int id) {
        return assetService.getAsset(id);
    }

    @PostMapping
    private AssetTypeDto insertAsset(@RequestBody AssetTypeDto assetDto) {
        return assetService.setAsset(assetDto);
    }

    @PutMapping
    private AssetTypeDto updateAsset(@RequestBody AssetTypeDto assetDto) {
        return assetService.updateAsset(assetDto);
    }

    @DeleteMapping("/{assetId}")
    private Boolean deleteAsset(@PathVariable("assetId") int id) {
        return assetService.deleteAsset(id);
    }

    @GetMapping
    private List<AssetTypeDto> getAllAssets() {
        return assetService.getAllAssetDetails();
    }
}
