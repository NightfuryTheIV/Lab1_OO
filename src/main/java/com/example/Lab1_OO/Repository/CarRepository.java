package com.example.Lab1_OO.Repository;

import com.example.Lab1_OO.Entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    Car findById(long id);
    Car findByPlateNumber(String plateNumber);
    List<Car> findAll();
    boolean existsById(long id);
    boolean existsByPlateNumber(String plateNumber);
    Car save(Car car);
}
