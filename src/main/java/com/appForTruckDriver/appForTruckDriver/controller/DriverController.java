package com.appForTruckDriver.appForTruckDriver.controller;

import com.appForTruckDriver.appForTruckDriver.model.Driver;
import com.appForTruckDriver.appForTruckDriver.repository.DriverRepository;
import com.appForTruckDriver.appForTruckDriver.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    private final DriverRepository driverRepository;
    private final DriverService driverService;

    public DriverController(DriverRepository driverRepository, DriverService driverService) {
        this.driverRepository = driverRepository;
        this.driverService = driverService;
    }

    @GetMapping("/getAll")
    public List<Driver> getAllDrivers (){
        return driverRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    private Driver getById (@PathVariable("id") Integer id){
        return driverRepository.findById(id).get();
    }

    @GetMapping("/getByName/{name}")
    private Driver getByName(@PathVariable("name") String name){
        return driverRepository.findByName(name);
    }

    @PostMapping("/postNew")
    public Driver postNew (@RequestBody Driver driver){
       return driverService.postNew(driver);
    }
}
