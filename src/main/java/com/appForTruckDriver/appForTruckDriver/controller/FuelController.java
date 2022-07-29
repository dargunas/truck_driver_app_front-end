package com.appForTruckDriver.appForTruckDriver.controller;

import com.appForTruckDriver.appForTruckDriver.model.Fuel;
import com.appForTruckDriver.appForTruckDriver.repository.FuelRepository;
import com.appForTruckDriver.appForTruckDriver.service.FuelService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fuel")
public class FuelController {

    private final FuelRepository fuelRepository;
    private final FuelService fuelService;

    public FuelController(FuelRepository fuelRepository, FuelService fuelService) {
        this.fuelRepository = fuelRepository;
        this.fuelService = fuelService;
    }

    @GetMapping("/getAll")
    public List<Fuel> getAllFuelRecords(){
        return fuelRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Fuel getFuelById(@PathVariable ("id") Integer id){
        return fuelRepository.findById(id).get();
    }

    @GetMapping("/getByDate/{date}")
    public List<Fuel> getByDate (@PathVariable ("date") String stringDate){
        LocalDate date = LocalDate.parse(stringDate);
        List <Fuel> fuels = fuelRepository.findByDate(date);
        return fuels;
    }

    @PostMapping("/postNew")
    public Fuel postNew (@RequestBody Fuel fuel){
       return fuelService.postNew(fuel);
    }
}
