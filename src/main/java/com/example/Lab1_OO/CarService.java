package com.example.Lab1_OO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@RestController
public class CarService {
    public static List<Car> cars;

    public String carsToString() {
        String carsString = "";
        for (Car car : cars) {
            carsString = carsString.concat(car.toString());
            carsString = carsString.concat(" \n");
        }
        return carsString;
    }

    @GetMapping(value = "/cars/", produces = "text/html")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String listOfCars() {
        cars = new ArrayList<>();

        new Car();
        new Car();
        new Car();
        new Car();
        new Car();
        new Car();
        new Car();
        new Car();
        new Car();

        String html = "<html>" +
                "<head>" +
                "<title>Cars</title>" +
                "</head>" +
                "<body>" +

                "<h1>List of cars</h1>" +

                "<p>" + carsToString() + "</p>" +

                "<h2>Search for a car</h2>" +

                "<form onsubmit=\"goToCar(); return false;\">" +
                "<input type=\"text\" id=\"plateNumber\" placeholder=\"AB-123-CD\">" +
                "<button type=\"submit\">Search</button>" +
                "</form>" +

                "<script>" +
                "function goToCar() {" +
                "    let plate = document.getElementById('plateNumber').value;" +
                "    window.location.href = '/cars/' + plate;" +
                "}" +
                "</script>" +

                "</body>" +
                "</html>";

        return html;
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        for (Car car : cars){
            if (Objects.equals(plateNumber, car.getPlatenumber())){
                return car;
            }
        }
        return null;
    }

    @PutMapping(value = "/cars/{plateNumber}")
    public void rentReturn(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true) boolean rent,
            @RequestBody Dates dates) {
        System.out.println("Check 0");

        for (Car car : cars){
            if (Objects.equals(plateNumber, car.getPlatenumber())){
                System.out.println("Check 1");

                if (rent) {
                    System.out.println("Check 2");

                    car.setAvailable(false);
                    car.setIfRented(new Dates("10/12/2006", "20/12/2008"));
                } else {
                    System.out.println("Check 6");

                    car.setAvailable(true);
                    car.resetDates();
                }
                break;
            }
        }
    }
}
