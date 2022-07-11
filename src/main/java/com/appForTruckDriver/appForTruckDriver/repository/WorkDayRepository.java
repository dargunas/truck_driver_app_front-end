package com.appForTruckDriver.appForTruckDriver.repository;

import com.appForTruckDriver.appForTruckDriver.model.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

@Repository
@Table
public interface WorkDayRepository extends JpaRepository<WorkDay, Integer> {
}
