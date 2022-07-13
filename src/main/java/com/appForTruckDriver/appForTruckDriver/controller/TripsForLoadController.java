package com.appForTruckDriver.appForTruckDriver.controller;

import com.appForTruckDriver.appForTruckDriver.model.TripsForLoad;
import com.appForTruckDriver.appForTruckDriver.repository.TripsForLoadRepository;
import com.appForTruckDriver.appForTruckDriver.service.TripsForLoadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tripsForLoad")
public class TripsForLoadController {

    private final TripsForLoadRepository tripsForLoadRepository;

    private final TripsForLoadService tripsForLoadService;

    public TripsForLoadController(TripsForLoadRepository tripsForLoadRepository, TripsForLoadService tripsForLoadService) {
        this.tripsForLoadRepository = tripsForLoadRepository;
        this.tripsForLoadService = tripsForLoadService;
    }

    @GetMapping("/getAll")
    public List<TripsForLoad> getAll (){
        return tripsForLoadRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public TripsForLoad getById (@PathVariable("id") Integer id){
        return tripsForLoadRepository.findById(id).get();
    }


    @PostMapping("/postNew")
    public TripsForLoad postNew (@RequestBody TripsForLoad tripsForLoad){
        return tripsForLoadService.postNew(tripsForLoad);
    }
}
