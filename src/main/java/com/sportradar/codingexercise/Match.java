package com.sportradar.codingexercise;

public class Match {
    private String homeTeam = "";
    private String awayTeam = "";

    public Match() {

    }

    public Match(String homeTeamName, String awayTeamName) {
        homeTeam = homeTeamName;
        awayTeam = awayTeamName;
    }

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
