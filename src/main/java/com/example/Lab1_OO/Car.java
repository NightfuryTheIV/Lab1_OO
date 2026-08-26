package com.example.Lab1_OO;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Car {
    private String brand;
    private String plateNumber;
    private int price;

    public Car() {
        Random random = new Random();

        List<String> possiblebrands = Arrays.asList("Koeniggsegg", "Lotus", "Chevrolet", "Alpine", "Hennessey", "Trion", "Lamborghini", "Mercedes-Benz", "Buick", "Porsche");
        brand = possiblebrands.get(random.nextInt(possiblebrands.size()));
        price = ThreadLocalRandom.current().nextInt(100000, 500000);

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
        List<String> possiblebrands = Arrays.asList("Koeniggsegg", "Lotus", "Chevrolet", "Alpine", "Hennessey", "Trion", "Lamborghini", "Mercedes-Benz", "Buick", "Porsche");
        brand = possiblebrands.get(new Random().nextInt(possiblebrands.size()));
        price = ThreadLocalRandom.current().nextInt(100000, 500000);

        CarService.cars.add(this);
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
