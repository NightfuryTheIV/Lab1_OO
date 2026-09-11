package com.example.Lab1_OO.Controller;

import com.example.Lab1_OO.Entity.Car;
import com.example.Lab1_OO.Service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    private final CarService carService;

    public String carsToString() {
        String carsString = "<ul>";
        String str1 = "";
        String str2 = "";
        for (Car car : carService.getCars()) {
            str1 = "</br><li><a href=/cars/%s style='color: #000000; text-decoration: none;'>";
            str2 = String.format(str1, car.getPlatenumber());
            carsString = carsString.concat(str2);
            carsString = carsString.concat(car.getPlatenumber());
            carsString = carsString.concat("</a></li>");
        }
        carsString = carsString.concat("</ul>");
        return carsString;
    }

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars/", produces = "text/html")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String listOfCars() {

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

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public String getCar(@PathVariable String plateNumber) {
        Car res = carService.plateNumberFind(plateNumber);
        return res.toString();
    }

    @PutMapping("/cars/{plateNumber}")
    public Car rentReturn(
            @PathVariable String plateNumber,
            @RequestParam boolean rent) {

        return carService.rentReturn(plateNumber, rent);
    }
}