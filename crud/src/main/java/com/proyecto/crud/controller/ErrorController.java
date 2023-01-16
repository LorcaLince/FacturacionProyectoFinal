package com.proyecto.crud.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/")
    public String hello() {
        return "service is up and running";
    }

}