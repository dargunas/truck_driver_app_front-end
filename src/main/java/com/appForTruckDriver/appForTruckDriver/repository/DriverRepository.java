package com.appForTruckDriver.appForTruckDriver.repository;

import com.appForTruckDriver.appForTruckDriver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Driver findByName(String name);




}
