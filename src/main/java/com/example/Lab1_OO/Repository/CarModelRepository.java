package com.example.Lab1_OO.Repository;

import com.example.Lab1_OO.Entity.Car;
import java.util.List;

public interface CarModelRepository {
    List<Car> findAll();
}
