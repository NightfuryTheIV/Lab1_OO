package com.example.Lab1_OO.Service;

import com.example.Lab1_OO.Entity.Client;
import com.example.Lab1_OO.Exception.NotSavedInDatabaseException;
import com.example.Lab1_OO.Repository.ClientRepository;
import com.example.Lab1_OO.Repository.RentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;
    private final RentRepository rentRepository;

    public ClientService(ClientRepository clientRepository, RentRepository rentRepository){
        this.clientRepository = clientRepository;
        this.rentRepository = rentRepository;
    }

    //Methods
    public void addPerson(Client client){
        try {
            clientRepository.save(client);
            log.warn("Person added: {}", client);
        }
        catch (Exception e) {
            throw new NotSavedInDatabaseException("Can't add person in database : " + e.getMessage());
        }
    }

    public List<Client> getClients(){
        return (List<Client>) clientRepository.findAll();
    }
}