package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RMResponse {

    private Info info;
    private List<Personagem> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Personagem> getResults() {
        return results;
    }

    public void setResults(List<Personagem> results) {
        this.results = results;
    }
}
