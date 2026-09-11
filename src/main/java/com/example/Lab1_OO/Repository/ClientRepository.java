package com.example.Lab1_OO.Repository;

import com.example.Lab1_OO.Entity.Rent;

import java.util.List;

public interface ClientRepository {
    List<Rent> getContractHistory();
}
