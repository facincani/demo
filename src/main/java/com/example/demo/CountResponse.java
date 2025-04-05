package com.example.demo;

public class CountResponse {

    private Long aliens;
    private Long humans;

    public CountResponse(Long aliens, Long humans) {
        this.aliens = aliens;
        this.humans = humans;
    }

    public Long getAliens() {
        return aliens;
    }

    public void setAliens(Long aliens) {
        this.aliens = aliens;
    }

    public Long getHumans() {
        return humans;
    }

    public void setHumans(Long humans) {
        this.humans = humans;
    }
}
