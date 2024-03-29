package com.sportradar.codingexercise;

public class Match {
    private String homeTeam = "";
    private String awayTeam = "";
    private final int[] score = {0, 0};

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

    public int[] getScore() {
        return score;
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        score[0] = homeTeamScore;
        score[1] = awayTeamScore;
    }

    @Override
    public String toString() {
        return STR."\{homeTeam}\{homeTeam.isEmpty() ? "" : " "}\{score[0]} - \{awayTeam}\{awayTeam.isEmpty() ? "" : " "}\{score[1]}";
    }
}
