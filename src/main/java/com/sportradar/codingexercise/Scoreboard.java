package com.sportradar.codingexercise;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
    Map<String, Match> matches = new HashMap<>();

    private String calculateMatchKey(String homeTeamName, String awayTeamName)
    {
        return STR."\{homeTeamName}_\{awayTeamName}";
    }

    public void Add(Match match){

    }

    public void startMatch(String homeTeamName, String awayTeamName) {
        matches.put(calculateMatchKey(homeTeamName, awayTeamName), new Match(homeTeamName, awayTeamName));
    }

    public boolean matchInProgress(String homeTeamName, String awayTeamName) {
        return matches.containsKey(calculateMatchKey(homeTeamName, awayTeamName));
    }
}