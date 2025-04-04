package com.example.demo.controller;

import com.example.demo.Personagem;
import com.example.demo.RMResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(@RequestParam String nome){
//        return "Hello " + nome;
        return consultaWebService();
    }

    private String consultaWebService(){
        String next = null;
        try {
            URL url = new URL("https://rickandmortyapi.com/api/character");

            ObjectMapper objectMapper = new ObjectMapper();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            RMResponse p = objectMapper.readValue(url.openStream(), RMResponse.class);
            next = p.getInfo().getNext();

        }catch (MalformedURLException e){
            System.out.println("Sua URL tá zuada");
        }catch (IOException e){
            System.out.println("Deu bom não");
        }
        return next;

    }
}