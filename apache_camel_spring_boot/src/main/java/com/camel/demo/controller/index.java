package com.camel.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {

    @GetMapping("/")
    public String sayHello() {
        return "Welcame to Camel Demo!";
    }
}
