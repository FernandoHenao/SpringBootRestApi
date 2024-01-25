package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//https://spring.io/guides/tutorials/rest/

@RestController
public class EmployeeController {

    @GetMapping("/greet")
    public String index(@RequestParam String fName, @RequestParam String lName) {
        return "Hello " + fName + " " + lName;
    }

    @PostMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
