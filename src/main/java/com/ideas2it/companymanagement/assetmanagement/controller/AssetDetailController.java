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

@RestController
@RequestMapping("/assetInfo")
public class AssetDetailController {

    private final AssetDetailService assetDetailService;

    public AssetDetailController(AssetDetailService assetDetailService) {
        this.assetDetailService = assetDetailService;
    }

    @PostMapping
    private AssetDetailsDto insertAssetDetails(@RequestBody AssetDetailsDto assetDetailsDto) {
        return assetDetailService.setAssertDetails(assetDetailsDto);
    }

    @GetMapping("/{assetInfoId}")
    private AssetDetailsDto getAssetDetails(@PathVariable("assetInfoId") int id) {
        return assetDetailService.getAssetDetails(id);
    }

    @PutMapping
    private AssetDetailsDto updateAssetDetails(@RequestBody AssetDetailsDto assetDetailsDto) {
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
