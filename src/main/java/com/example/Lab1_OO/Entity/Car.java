package com.example.Lab1_OO.Entity;
import com.example.Lab1_OO.Service.CarServiceImpl;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;

    private String plateNumber;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_model_id")
    private CarModel carModel;

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

        carModel = new CarModel();
        carModel.getId();
    }

    public Car(String plateNumber) {
        price = ThreadLocalRandom.current().nextInt(100000, 500000);

        this.plateNumber = plateNumber;
        this.carModel = new CarModel();
    }

    public Car(String plateNumber, CarModel carModel) {
        price = ThreadLocalRandom.current().nextInt(100000, 500000);
        this.plateNumber = plateNumber;
        this.carModel = carModel;
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

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public boolean isRent() throws Exception {
        int activecounter = 0;
        for (Rent rent : contractHistory) {
            System.out.println(rent.getStatus());
            if (Objects.equals(rent.getStatus(), "ACTIVE")) {
                activecounter++;
            }
        }

        if (activecounter == 0) {
            return false;
        } else if (activecounter == 1) {
            return true;
        } else {
            throw new Exception("ERROR: Car is being rented by two users at once.");
        }
    }

    @Override
    public String toString() {
        if (carModel == null) {
            return "<p>plateNumber: " + plateNumber +
                    "</br>brand: No model assigned" +
                    "</br>price: " + price + " €</p>";
        }

        try {
            if (this.isRent()) {
                return "<p>plateNumber: " + plateNumber +
                        "</br>brand: " + carModel.getBrand() +
                        "</br>price: " + price + " €</p>" +
                        "</br>rented? " + "yes";
            } else {
                return "<p>plateNumber: " + plateNumber +
                        "</br>brand: " + carModel.getBrand() +
                        "</br>price: " + price + " €</p>" +
                        "</br>rented? " + " no";
            }
        } catch (Exception e) {
            System.err.println("ERROR: Car is being rented by two users at once.");
        }
        return null;
    }

    public void makeNewContract() {
        contractHistory.add(new Rent());
    }

    public void terminateContract() { // purposefully terminates all the contracts since only one should be active anyway
        for (Rent rent : contractHistory) {
            if (Objects.equals(rent.getStatus(), "ACTIVE")) {
                rent.setStatus("INACTIVE");
            }
        }
    }
}
