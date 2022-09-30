package com.ideas2it.companymanagement.seatmanagement.controller;

import com.ideas2it.companymanagement.seatmanagement.dto.AllocationDto;
import com.ideas2it.companymanagement.seatmanagement.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seatAllotment")
public class AllocationController {
    private final AllocationService allocationService;
    @Autowired
    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }
    @PostMapping
    public AllocationDto addAllocation(@RequestBody AllocationDto allocationDto) {
        return allocationService.insertSeatAllocation(allocationDto);
    }
    @GetMapping("/{id}")
    public AllocationDto getAllocationById(@PathVariable("id") int id) {
        return allocationService.getSeatById(id);
    }
    @GetMapping
    public List<AllocationDto> getAllocation(){
        return allocationService.getSeatDetails();
    }
    @PutMapping("{id}")
    public AllocationDto updateAllocation(@RequestBody AllocationDto allocationDto) {
        return allocationService.updateSeat(allocationDto);
    }
    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable("id") int id){
        if (allocationService.deleteEmployeeById(id)) {
            return "Deleted";
        } else {
            return "Try again";
        }
    }
}
