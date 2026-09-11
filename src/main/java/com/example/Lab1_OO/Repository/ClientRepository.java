package com.example.Lab1_OO.Repository;

import com.example.Lab1_OO.Entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Iterable<Client> findAll();
}
