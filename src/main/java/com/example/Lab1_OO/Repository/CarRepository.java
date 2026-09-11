package com.example.Lab1_OO.Repository;

import com.example.Lab1_OO.Entity.Car;

import java.util.List;

public interface CarRepository {

    Car findById(int id);
    Car findByPlateNumber(String plateNumber);
    List<Car> findAll();
    boolean existsById(int id);
    boolean existsByPlateNumber(String plateNumber);
    void save(Car car);
}
