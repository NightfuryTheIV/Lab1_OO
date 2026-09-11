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

        Car car1 = new Car("XX-000-XX", "FIAT", "Panda");
        carRepository.save(car1);
        Car car2 = new Car("AB-987-CD", "Bugatti", "La Voiture Noire");
        carRepository.save(car2);
        Car car3 = new Car("MD-007-RR", "Volkswagen", "Golf");
        carRepository.save(car3);
        Car car4 = new Car("AHAHA", "Pagani", "Huayra");
        carRepository.save(car4);
        Car car5 = new Car("TYPESHIFT", "Vélo", "Électrique");
        carRepository.save(car5);

    }
}