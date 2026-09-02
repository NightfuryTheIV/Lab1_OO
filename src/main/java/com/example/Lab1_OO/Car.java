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
    private boolean available;
    private Dates ifRented;

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
        available = true;

        CarService.cars.add(this);
    }

    public Car(int a) {
        brand = "";
        plateNumber = "";
        price = a;
        available = false;
        ifRented = null;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public  Dates getIfRented() {
        return ifRented;
    }

    public void setIfRented(Dates ifRented) {
        this.ifRented = ifRented;
    }

    public void resetDates() {
        ifRented.setBegin("");
        ifRented.setEnd("");
    }

    @Override
    public String toString() {
        if (this.plateNumber.isEmpty()) {
            return "Sorry, we don't have this one in stock.";
        }
        return "plateNumber: " + plateNumber + "; brand: " + brand + "; price: " + price + " €                             ";
    }
}
