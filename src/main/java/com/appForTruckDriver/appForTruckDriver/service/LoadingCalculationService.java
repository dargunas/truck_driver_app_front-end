package com.appForTruckDriver.appForTruckDriver.service;

import com.appForTruckDriver.appForTruckDriver.model.TripsForLoad;
import com.appForTruckDriver.appForTruckDriver.repository.CargoRepository;
import com.appForTruckDriver.appForTruckDriver.repository.TripsForLoadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoadingCalculationService {

    private final Logger LOGGER = LoggerFactory.getLogger(LoadingCalculationService.class);

    private final TripsForLoadRepository tripsForLoadRepository;
    private final CargoRepository cargoRepository;

    public LoadingCalculationService(TripsForLoadRepository tripsForLoadRepository, CargoRepository cargoRepository) {
        this.tripsForLoadRepository = tripsForLoadRepository;
        this.cargoRepository = cargoRepository;
    }
// TODO istestuoti ar viskas veikia. Pagalvoti kaip isskaidyti metoda i mazesnius.

    public void calculateMaxHeightOnPallet (LocalDate date, Integer trip){
        try {
            List<TripsForLoad> tripsForLoadsByDate = tripsForLoadRepository.findByDate(date);
            TripsForLoad tripsForLoadsByTripNumberAndDate = null;
            for (TripsForLoad tripsForLoad : tripsForLoadsByDate) {
                if (tripsForLoad.getTripNumber().equals(trip)) {
                    tripsForLoadsByTripNumberAndDate = tripsForLoad;
                }
            }
            assert false;
            Integer boxTotalToGet = tripsForLoadsByTripNumberAndDate.getBoxQuantity();
            Double boxTotal = Double.valueOf(boxTotalToGet);
            Integer palletsToLoad = 0;
            Double quantityOfBoxesOnPallet;
            do {
                palletsToLoad++;
                quantityOfBoxesOnPallet = boxTotal / palletsToLoad;
            } while (quantityOfBoxesOnPallet > 72);

            Double rowHeight = quantityOfBoxesOnPallet / 4;
            tripsForLoadsByTripNumberAndDate.setRowHeight(rowHeight);
            tripsForLoadsByTripNumberAndDate.setPalletsForTrip(palletsToLoad);
            tripsForLoadRepository.save(tripsForLoadsByTripNumberAndDate);
            LOGGER.warn("Calculated value of quantity of boxes on pallet is:  ");
            LOGGER.warn(String.valueOf(quantityOfBoxesOnPallet));
            LOGGER.warn(" Calculated value of boxes in row is: ");
            LOGGER.warn(String.valueOf(rowHeight));
        }catch (NullPointerException exception){
            LOGGER.warn("There is some Null values!!!");
        }
    }

// TODO Sutvarkyti metoda, kazkas nelimpa....

//    public void validationIfThereIsEnoughSpaceOnTrailer(LocalDate date, String numberPlate) throws Exception {
//        Integer maxPalletsOnTrailer = 33;
//        List<TripsForLoad> tripsForLoads = tripsForLoadRepository.findByDate(date);
//        List<TripsForLoad> tripsForLoadOfThatTruck = new ArrayList<>();
//        try {
//            for (TripsForLoad tripsForLoad : tripsForLoads) {
//                if (tripsForLoad.getCargo().getTruck().getNumberPlate().equals(numberPlate)) {
//                    assert false;
//                    tripsForLoadOfThatTruck.add(tripsForLoad);
//                }
//            }
//            Integer totalPalletsCalculatedForTrip = 0;
//            for (TripsForLoad tripsForLoad : tripsForLoadOfThatTruck) {
//                totalPalletsCalculatedForTrip = totalPalletsCalculatedForTrip + tripsForLoad.getPalletsForTrip();
//            }
//            LOGGER.warn("pallets fits to trailer");
//            LOGGER.warn("Pallets doesn't fit on trailer ");
//            throw new Exception(" there is to much pallets!!!!!!!!!!!");
//
//        Integer palletsToMuch = 0;
//
//        }catch (NullPointerException exception){
//            LOGGER.warn("There is no trucks assigned with this numberplate");
//        }catch (Exception exception){
//            LOGGER.warn("Something went Wrong on validationIfThereEnoughSpaceOnTrailer!!!!!!!!!!!");
//        }
//        if(maxPalletsOnTrailer >= totalPalletsCalculatedForTrip){
//            LOGGER.warn("pallets fits to trailer");
//        }else
//            palletsToMuch = totalPalletsCalculatedForTrip - maxPalletsOnTrailer;
//            LOGGER.warn("Pallets doesn't fit on trailer ", palletsToMuch);
//        throw new Exception(" there is to much pallets!!!!!!!!!!!");
//    }




}
