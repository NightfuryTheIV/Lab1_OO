package com.example.Lab1_OO.Repository;

import com.example.Lab1_OO.Entity.Rent;
import org.springframework.data.repository.CrudRepository;


public interface RentRepository extends CrudRepository<Rent, Long> {
}
