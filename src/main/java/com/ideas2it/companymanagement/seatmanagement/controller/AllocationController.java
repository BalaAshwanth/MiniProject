package com.ideas2it.companymanagement.seatmanagement.controller;

import com.ideas2it.companymanagement.seatmanagement.dto.SeatDto;
import com.ideas2it.companymanagement.seatmanagement.service.AllocationService;
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
@RequestMapping("/seat")
public class AllocationController {
    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    /**
     * <p>
     * Creates new allocation and sends to allocation service.
     * </p>
     *
     * @param seatDto
     * @return SeatDto
     */
    @PostMapping
    public SeatDto addAllocation(@RequestBody SeatDto seatDto) {
        return allocationService.insertSeat(seatDto);
    }

    /**
     * <p>
     * Searches and deletes allocation based on the given id.
     * </p>
     *
     * @param id
     * @return SeatDto
     *
     */
    @GetMapping("/{id}")
    public SeatDto getAllocationById(@PathVariable("id") int id) {
        return allocationService.getSeat(id);
    }

    /**
     * <p>
     * retrieves all allocation .
     * </p>
     *
     * @return List<SeatDto>
     *
     */
    @GetMapping
    public List<SeatDto> getAllocation() {
        return allocationService.getAllSeat();
    }

    /**
     * <p>
     * Initiates the process of updating allocation.
     * </p>
     *
     * @param seatDto
     * @return SeatDto
     */
    @PutMapping
    public SeatDto updateAllocation(@RequestBody SeatDto seatDto) {
        return allocationService.updateSeat(seatDto);
    }

    /**
     * <p>
     * Searches and deletes seat based on the given id.
     * </p>
     *
     * @param id
     * @return String
     *
     */
    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable("id") int id) {
        if (allocationService.deleteSeat(id)) {
            return "Deleted";
        } else {
            return "Try again";
        }
    }
}
