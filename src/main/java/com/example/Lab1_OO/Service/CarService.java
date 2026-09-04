package com.example.Lab1_OO.Service;

import com.example.Lab1_OO.Entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    String listOfCars();
    Car plateNumberFind(String platenumber);
    String plateNumberDisplay(String plateNumber);
    Car rentReturn(String plateNumber, boolean rent);
    Car findById(long id);
    void updateCar(long id, Car car);
}
