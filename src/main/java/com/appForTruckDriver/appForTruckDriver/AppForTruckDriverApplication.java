package com.appForTruckDriver.appForTruckDriver;

import com.appForTruckDriver.appForTruckDriver.repository.TripsForLoadRepository;
import com.appForTruckDriver.appForTruckDriver.service.LoadingCalculationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppForTruckDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppForTruckDriverApplication.class, args);
	}
}
