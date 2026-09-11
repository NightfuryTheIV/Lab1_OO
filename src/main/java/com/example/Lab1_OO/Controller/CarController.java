package com.example.Lab1_OO.Controller;

import com.example.Lab1_OO.Entity.Car;
import com.example.Lab1_OO.Service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCar(@PathVariable String plateNumber) {
        return carService.plateNumberFind(plateNumber);
    }

    @PutMapping("/cars/{plateNumber}")
    public Car rentReturn(
            @PathVariable String plateNumber,
            @RequestParam boolean rent) {

        return carService.rentReturn(plateNumber, rent);
    }
}