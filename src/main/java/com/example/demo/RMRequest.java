package com.example.demo;

import java.util.List;

public class RMRequest {

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
