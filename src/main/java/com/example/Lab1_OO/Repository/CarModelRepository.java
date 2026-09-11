package com.example.Lab1_OO.Repository;

import com.example.Lab1_OO.Entity.CarModel;
import org.springframework.data.repository.CrudRepository;

public interface CarModelRepository extends CrudRepository<CarModel, Long> {
    Iterable<CarModel> findAll();
}
