package com.example.Lab1_OO.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private double lowestPrice;
    private double highestPrice;

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();

    public CarModel() {
        Random random = new Random();
        List<String> possiblebrands = Arrays.asList("Koeniggsegg", "Lotus", "Chevrolet", "Alpine", "Hennessey", "Trion", "Lamborghini", "Mercedes-Benz", "Buick", "Porsche");
        brand = possiblebrands.get(random.nextInt(possiblebrands.size()));
        model = "TBD";
    }

    public CarModel(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public CarModel(String brand, String model, double lowestPrice, double highestPrice) {
        this.brand = brand;
        this.model = model;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
