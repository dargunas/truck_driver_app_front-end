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

//    private final DriverRepository driverRepository;
//
//    public DriverService(DriverRepository driverRepository) {
//        this.driverRepository = driverRepository;
//    }

//    public Driver findById (Integer id) {
//        Driver driver = driverRepository.findById(id).get();
//        return driver;
//    }
//Veikia su Driver Repository.....

//    public Driver findByName(String name){
//        List<Driver> drivers = driverRepository.findAll();
//        Driver driverToSend = null;
//        for (Driver driver : drivers) {
//            if (driver.getName().equals(name)){
//                driverToSend = driver;
//            }
//        }
//        return driverToSend;
//    }
}


