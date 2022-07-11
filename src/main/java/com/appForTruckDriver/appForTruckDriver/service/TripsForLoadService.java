package com.appForTruckDriver.appForTruckDriver.service;

import com.appForTruckDriver.appForTruckDriver.model.TripsForLoad;
import com.appForTruckDriver.appForTruckDriver.repository.TripsForLoadRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class TripsForLoadService {

    private final TripsForLoadRepository tripsForLoadRepository;

    public TripsForLoadService(TripsForLoadRepository tripsForLoadRepository) {
        this.tripsForLoadRepository = tripsForLoadRepository;
    }

    public TripsForLoad postNew (TripsForLoad tripsForLoad){
        TripsForLoad tripsForLoadToSave = TripsForLoad.builder()
                .tripNumber(tripsForLoad.getTripNumber())
                .build();
        tripsForLoadRepository.save(tripsForLoadToSave);
        return tripsForLoadToSave;
    }
}
