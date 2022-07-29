package com.appForTruckDriver.appForTruckDriver.controller;


import com.appForTruckDriver.appForTruckDriver.model.WorkDay;
import com.appForTruckDriver.appForTruckDriver.repository.WorkDayRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/workDay")
public class WorkDayController {

    private final WorkDayRepository workDayRepository;

    public WorkDayController(WorkDayRepository workDayRepository) {
        this.workDayRepository = workDayRepository;
    }


    @GetMapping("/getAll")
    public List<WorkDay> getAllWorkDays (){
        return workDayRepository.findAll();
    }
}
