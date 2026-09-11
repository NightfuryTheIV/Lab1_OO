package com.example.Lab1_OO.Service;

import com.example.Lab1_OO.Entity.Car;

public interface CarService {
    Iterable<Car> getCars();
    Car createCar(String plate, String brand, String model);
    Car plateNumberFind(String platenumber);
    Car rentReturn(String plateNumber, boolean rent);
    void updateCar(long id, Car car);
}
