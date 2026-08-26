package com.example.Lab1_OO;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloService {
    @GetMapping("/")
    public List hello() {
        return new ArrayList();
    }
}
