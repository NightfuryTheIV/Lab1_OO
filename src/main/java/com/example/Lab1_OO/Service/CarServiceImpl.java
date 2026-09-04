package com.example.Lab1_OO.Service;
import com.example.Lab1_OO.Entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@Service
public class CarServiceImpl implements CarService {
    public static List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public String carsToString() {
        String carsString = "<ul>";
        String str1 = "";
        String str2 = "";
        for (Car car : cars) {
            str1 = "</br><li><a href=/cars/%s style='color: #000000; text-decoration: none;'>";
            str2 = String.format(str1, car.getPlatenumber());
            carsString = carsString.concat(str2);
            carsString = carsString.concat(car.getPlatenumber());
            carsString = carsString.concat("</a></li>");
        }
        carsString = carsString.concat("</ul>");
        return carsString;
    }

    @GetMapping(value = "/cars/", produces = "text/html")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Override
    public String listOfCars() {
        cars = new ArrayList<>();

        for (int i = 0; i <= ThreadLocalRandom.current().nextInt(20, 50); i++) {
            new Car();
        }


        String html = "<html>" +
                "<head>" +
                "<title>Cars</title>" +
                "</head>" +
                "<body>" +

                "<h1 style='text-align: center'>List of cars</h1>" +

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

    @Override
    public Car plateNumberFind(String platenumber) {
        for (Car car : cars) {
            if (car.getPlatenumber().equals(platenumber)) {
                return car;
            }
        }
        return null;
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String plateNumberDisplay(@PathVariable("plateNumber") String plateNumber) { // aCar()
        Car res = plateNumberFind(plateNumber);
        if (res != null) {
            return res.toString();
        }
        return "Sorry, we don't have this one in stock.";
    }

    @PutMapping(value = "/cars/{plateNumber}")
    public Car rentReturn(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true) boolean rent) {

        for (Car car : cars){
            if (Objects.equals(plateNumber, car.getPlatenumber())){

                if (rent) {
                    car.makeNewContract();
                } else {
                    car.terminateContract();
                }
                return car;
            }
        }
        return null;
    }

    @Override
    public Car findById(long id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void updateCar(long id, Car car) {
        Car updated = findById(id);
        updated.setPlatenumber(car.getPlatenumber());
        updated.setCarModel(car.getCarModel());
        updated.setPrice(car.getPrice());
    }
}
