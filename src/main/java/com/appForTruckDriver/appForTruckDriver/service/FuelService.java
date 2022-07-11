package com.appForTruckDriver.appForTruckDriver.service;

import com.appForTruckDriver.appForTruckDriver.model.Fuel;
import com.appForTruckDriver.appForTruckDriver.repository.FuelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FuelService {

    private final FuelRepository fuelRepository;

    public FuelService(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    public Fuel postNew (Fuel fuel){

        Fuel fuelToAdd = Fuel.builder()
                .date(fuel.getDate())
                .dieselFuel(fuel.getDieselFuel())
                .adblue(fuel.getAdblue())
                .startKilometers(fuel.getStartKilometers())
                .endKilometers(fuel.getEndKilometers())
                .build();
        fuelRepository.save(fuelToAdd);
        return fuelToAdd;
    }

}