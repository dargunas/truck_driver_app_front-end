package com.appForTruckDriver.appForTruckDriver.service;


import com.appForTruckDriver.appForTruckDriver.model.Driver;
import com.appForTruckDriver.appForTruckDriver.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver postNew (Driver driver){
        Driver driverToAdd = Driver.builder()
                .name(driver.getName())
                .email(driver.getEmail())
                .password(driver.getPassword())
                .build();
        driverRepository.save(driverToAdd);
        return driverToAdd;
    }

}


