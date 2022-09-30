package com.ideas2it.companymanagement.assetmanagement.controller;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.service.AssetDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assetInfo")
public class AssetDetailController {

    private final AssetDetailService assetDetailService;

    public AssetDetailController(AssetDetailService assetDetailService) {
        this.assetDetailService = assetDetailService;
    }

    @PostMapping
    private AssetDetailsDto insertAssetDetails(AssetDetailsDto assetDetailsDto) {
        return assetDetailService.setAssertDetails(assetDetailsDto);
    }

    @GetMapping("/{assetInfoId}")
    private AssetDetailsDto getAssetDetails(@PathVariable("assetInfoId") int id) {
        return assetDetailService.getAssetDetails(id);
    }

    @PutMapping
    private AssetDetailsDto updateAssetDetails(AssetDetailsDto assetDetailsDto) {
        return assetDetailService.updateAssetDetails(assetDetailsDto);
    }

    @DeleteMapping("/{assetInfoId}")
    private boolean deleteAssetDetails(@PathVariable("assetInfoId") int id) {
        return assetDetailService.deleteAssetDetails(id);
    }

    @GetMapping
    private List<AssetDetailsDto> getAllAssetDetails() {
        return assetDetailService.getAllAssetDetails();
    }
}
