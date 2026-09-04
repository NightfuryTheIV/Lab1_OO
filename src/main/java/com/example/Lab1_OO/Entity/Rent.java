package com.example.Lab1_OO.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private LocalDateTime contractDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Rent() {
        contractDate = LocalDateTime.now();
        status = "ACTIVE";
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDateTime contractDate) {
        this.contractDate = contractDate;
    }

    public String getCarInfo() {
        return car.getCarModel().getBrand() + " " + car.getCarModel().getModel() + ": " + car.getPrice() + " €";
    }
}
