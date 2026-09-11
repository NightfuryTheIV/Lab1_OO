package com.example.Lab1_OO.Service;

import com.example.Lab1_OO.Entity.Car;
import com.example.Lab1_OO.Entity.CarModel;
import com.example.Lab1_OO.Exception.CarAlreadyExistsException;
import com.example.Lab1_OO.Exception.InvalidPlateException;
import com.example.Lab1_OO.Repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private static final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(String plate, String brand, String model) {
        checkPlateCorrectness(plate);
        checkPlateAvailability(plate);
        CarModel temp = new CarModel(brand, model);
        Car newCar = new Car(plate, temp);
        carRepository.save(newCar);
        return newCar;
    }

    private void checkPlateAvailability(String plate) {
        if (carRepository.existsByPlateNumber(plate)) {
            log.warn("Attempting to create a car with an already assigned plate.");
            throw new CarAlreadyExistsException(plate);
        }
    }

    private void checkPlateCorrectness(String plate) {
        if (plate == null || plate.isBlank()) {
            log.warn("Attempting to create a car with no plate number.");
            throw new InvalidPlateException("Invalid plate number.");
        }
    }

    @Override
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car plateNumberFind(String plateNumber) {
        for (Car car : carRepository.findAll()) {
            if (car.getPlatenumber().equals(plateNumber)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car rentReturn(String plateNumber, boolean rent) {

        Car car = plateNumberFind(plateNumber);

        if (car == null) {
            return null;
        }

        if (rent) {
            car.makeNewContract();
        } else {
            car.terminateContract();
        }

        carRepository.save(car);

        return car;
    }

    @Override
    public void updateCar(long id, Car car) {
        Car updated = carRepository.findById(id);

        if (updated == null) {
            return;
        }

        updated.setPlatenumber(car.getPlatenumber());
        updated.setCarModel(car.getCarModel());
        updated.setPrice(car.getPrice());

        carRepository.save(updated);
    }
}