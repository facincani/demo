package com.example.demo.controller;

import com.example.demo.CountResponse;
import com.example.demo.RMRequest;
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
    public CountResponse hello(){
//        return "Hello " + nome;
        return consultaWebService();
    }

    @PostMapping
    public void criaPersonagem(@RequestBody RMRequest request){
        System.out.println(request.getInfo());
    }



    private CountResponse consultaWebService(){
        CountResponse count = null;
        try {
            URL url = new URL("https://rickandmortyapi.com/api/character");

            ObjectMapper objectMapper = new ObjectMapper();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            RMResponse response = objectMapper.readValue(url.openStream(), RMResponse.class);

            Long humans = 0L;
            Long aliens = 0L;

            humans = response.getResults()
                    .stream()
                    .filter(r -> r.getSpecies().equals("Human")).count();
            aliens = response.getResults()
                    .stream()
                    .filter(r -> r.getSpecies().equals("Alien")).count();



//            for (int i = 0; i < response.getResults().size(); i++) {
//                String species = response.getResults().get(i).getSpecies();
//                if ("Human".equals(species)) {
//                    humans++;
//                } else if ("Alien".equals(species)) {
//                    aliens++;
//                }
//            }

//            for (Personagem r : response.getResults()) {
//                String species = r.getSpecies();
//                if ("Human".equals(species)) {
//                    humans++;
//                } else if ("Alien".equals(species)) {
//                    aliens++;
//                }
//            }

            count = new CountResponse(aliens, humans);

        }catch (MalformedURLException e){
            System.out.println("Sua URL tá zuada");
        }catch (IOException e){
            System.out.println("Deu bom não");
        }
        return count;

    }
}