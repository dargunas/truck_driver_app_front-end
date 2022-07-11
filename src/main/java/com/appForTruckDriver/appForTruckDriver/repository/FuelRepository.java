package com.appForTruckDriver.appForTruckDriver.repository;

import com.appForTruckDriver.appForTruckDriver.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Table
public interface FuelRepository extends JpaRepository <Fuel, Integer> {


    List<Fuel> findByDate (LocalDate date);
}
