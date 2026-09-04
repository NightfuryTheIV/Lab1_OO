package com.example.Lab1_OO.Service;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloService {
    @GetMapping("/")
    public String hello() {
        return "<h1 style='text-align: center'>Hello and welcome to the one and only Car Rental !</h1> <p><a href='./cars/' style='padding: 1px 6px; border: 1px outset buttonborder; border-radius: 3px; color: buttontext; background-color: buttonface; text-decoration: none;'>Car list</a></p>";
    }
}
