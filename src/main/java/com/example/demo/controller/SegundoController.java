package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola")
public class SegundoController {

    @GetMapping
    public String ola(){
        return "Olá";
    }

    @GetMapping("/olamundo")
    public String olaMundo(){
        return "Olá Mundo";
    }

}
