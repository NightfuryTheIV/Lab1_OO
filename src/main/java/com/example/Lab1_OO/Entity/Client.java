package com.example.Lab1_OO.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientID;

    private String username;
    private String userMail;

    // OneToMany towards AttemptJPA
    // An User can have multiple Attempts
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Rent> contractHistory = new ArrayList<>();


    // Constructor
    public Client() {
    }

    public Client(String username, String userMail) {
        this.userMail = userMail;
        this.username = username;
    }

    // Getters
    public Long getClientID() {
        return clientID;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUsername() {
        return username;
    }

    public List<Rent> getContractHistory() {
        return contractHistory;
    }


    // Setters
    public void setContractHistory(List<Rent> rents) {
        contractHistory = rents;
    }

    public void setClientID(Long userID) {
        this.clientID = userID;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    // Methods
    @Override
    public String toString() {
        return username + " : {" + userMail +  "}\n" + "Rents -> " + contractHistory;
    }
}
