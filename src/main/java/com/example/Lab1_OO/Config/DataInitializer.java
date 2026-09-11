package com.example.Lab1_OO.Config;

import com.example.Lab1_OO.Entity.Car;
import com.example.Lab1_OO.Repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) {

        for (int i = 0; i < 30; i++) {
            Car car = new Car();
            carRepository.save(car);
        }
    }
}