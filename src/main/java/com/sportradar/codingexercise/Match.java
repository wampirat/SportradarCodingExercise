package com.sportradar.codingexercise;

public class Match {
    private String homeTeam = "";
    private String awayTeam = "";
    public void setHomeTeam(String teamName) {
        homeTeam = teamName;
    }

    public void setAwayTeam(String teamName) {
        awayTeam = teamName;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }
}
