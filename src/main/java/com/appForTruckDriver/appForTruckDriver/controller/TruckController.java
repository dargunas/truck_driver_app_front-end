package com.appForTruckDriver.appForTruckDriver.controller;

import com.appForTruckDriver.appForTruckDriver.model.Truck;
import com.appForTruckDriver.appForTruckDriver.repository.TruckRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/truck")
public class TruckController {

    private final TruckRepository truckRepository;

    public TruckController(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @GetMapping("/getAll")
    public List<Truck> getAll (){
        return truckRepository.findAll();
    }
}
