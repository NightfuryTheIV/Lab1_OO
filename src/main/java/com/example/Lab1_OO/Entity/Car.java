package com.example.Lab1_OO.Entity;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;

    private String brand;
    private String model;
    private String plateNumber;
    private int price;
    private boolean rented;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rent> contractHistory = new ArrayList<>();


    public Car() {
        Random random = new Random();
        price = ThreadLocalRandom.current().nextInt(100000, 500000);

        char letter1 = (char) ('A' + random.nextInt(26));
        char letter2 = (char) ('A' + random.nextInt(26));
        String number = String.format("%03d", random.nextInt(1000));
        char letter3 = (char) ('A' + random.nextInt(26));
        char letter4 = (char) ('A' + random.nextInt(26));
        plateNumber = "" + letter1 + letter2 + "-" + number + "-" + letter3 + letter4;

        List<String> possiblebrands = Arrays.asList("Koeniggsegg", "Lotus", "Chevrolet", "Alpine", "Hennessey", "Trion", "Lamborghini", "Mercedes-Benz", "Buick", "Porsche");
        brand = possiblebrands.get(random.nextInt(possiblebrands.size()));
        model = "TBD";
        rented = false;
    }

    public Car(String plateNumber) {
        price = ThreadLocalRandom.current().nextInt(100000, 500000);

        this.plateNumber = plateNumber;

        List<String> possiblebrands = Arrays.asList("Koeniggsegg", "Lotus", "Chevrolet", "Alpine", "Hennessey", "Trion", "Lamborghini", "Mercedes-Benz", "Buick", "Porsche");
        Random random = new Random();
        brand = possiblebrands.get(random.nextInt(possiblebrands.size()));
        model = "TBD";
        rented = false;
    }

    public Car(String plateNumber, String brand, String model) {
        price = ThreadLocalRandom.current().nextInt(100000, 500000);
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        rented = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatenumber() {
        return plateNumber;
    }

    public void setPlatenumber(String platenumber) {
        this.plateNumber = platenumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    @Override
    public String toString() {
        if (Objects.equals(model, "TBD")) {
            return "<p>plateNumber: " + plateNumber +
                    "</br>brand: No model assigned" +
                    "</br>price: " + price + " €</p>";
        }

        if (this.rented) {
            return "<p>plateNumber: " + plateNumber +
                    "</br>brand: " + brand +
                    "</br>price: " + price + " €</p>" +
                    "</br>rented? " + "yes";
        } else {
            return "<p>plateNumber: " + plateNumber +
                    "</br>brand: " + brand +
                    "</br>price: " + price + " €</p>" +
                    "</br>rented? " + " no";
        }
    }

    public void makeNewContract() {
        contractHistory.add(new Rent());
        rented = true;
    }

    public void terminateContract() { // purposefully terminates all the contracts since only one should be active anyway
        for (Rent rent : contractHistory) {
            if (Objects.equals(rent.getStatus(), "ACTIVE")) {
                rent.setStatus("INACTIVE");
            }
        }
        rented = false;
    }
}
