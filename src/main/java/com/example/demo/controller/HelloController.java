package com.example.demo.controller;

import com.example.demo.Personagem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class HelloController {

    @GetMapping
    public String hello(){
        return consultaWebService();
    }

    private String consultaWebService(){
        String nome = null;
        try {
            URL url = new URL("https://rickandmortyapi.com/api/character/2");

            ObjectMapper objectMapper = new ObjectMapper();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Personagem p = objectMapper.readValue(url.openStream(), Personagem.class);
            nome = p.getName();

        }catch (MalformedURLException e){
            System.out.println("Sua URL tá zuada");
        }catch (IOException e){
            System.out.println("Deu bom não");
        }
        return nome;

    }
}