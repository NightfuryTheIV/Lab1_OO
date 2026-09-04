package com.example.Lab1_OO.Service;

import com.example.Lab1_OO.Entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    String listOfCars();
    String plateNumberDisplay(String plateNumber);
    Car rentReturn(String plateNumber, boolean rent);
    void updateCar(long id, Car car);
}
