package com.example.Lab1_OO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Car {
    private String brand;
    private String plateNumber;
    private int price;

    public Car() {
        Random random = new Random();
        brand = "Koeniggsegg";
        price = ThreadLocalRandom.current().nextInt(100, 50000);

        char letter1 = (char) ('A' + random.nextInt(26));
        char letter2 = (char) ('A' + random.nextInt(26));
        String number = String.format("%03d", random.nextInt(1000));
        char letter3 = (char) ('A' + random.nextInt(26));
        char letter4 = (char) ('A' + random.nextInt(26));
        plateNumber = "" + letter1 + letter2 + "-" + number + "-" + letter3 + letter4;
        CarService.cars.add(this);
    }

    public Car(String plate) {
        plateNumber = "BB-887-MW";
        List<String> possiblebrands = new ArrayList<>();
        possiblebrands = ("Koeniggsegg", "Lotus", "Chevrolet", "", "", "", "", "", "", "");
        brand = "Koeniggsegg";
        price = ThreadLocalRandom.current().nextInt(100, 50000);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlatenumber() {
        return plateNumber;
    }

    public void setPlatenumber(String platenumber) {
        this.plateNumber = platenumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "plateNumber: " + plateNumber + "; brand: " + brand + "; price: " + price + " €\n";
    }
}
