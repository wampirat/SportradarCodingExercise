package com.sportradar.codingexercise;
import java.util.*;

public class Scoreboard {
    Map<String, Match> matches = new HashMap<>();

    private String calculateMatchKey(String homeTeamName, String awayTeamName)
    {
        return STR."\{homeTeamName}_\{awayTeamName}";
    }

    public void startMatch(String homeTeamName, String awayTeamName) {
        if (!matchInProgress(homeTeamName, awayTeamName)) {
            matches.put(calculateMatchKey(homeTeamName, awayTeamName), new Match(homeTeamName, awayTeamName));
        }
    }

    public boolean matchInProgress(String homeTeamName, String awayTeamName) {
        return matches.containsKey(calculateMatchKey(homeTeamName, awayTeamName));
    }

    public void finishMatch(String homeTeamName, String awayTeamName) {
        matches.remove(calculateMatchKey(homeTeamName, awayTeamName));
    }

    public int[] getScore(String homeTeamName, String awayTeamName) {
        String matchKey = calculateMatchKey(homeTeamName, awayTeamName);
        return matches.containsKey(matchKey) ? matches.get(matchKey).getScore() : new int[] {};
    }

    public void updateScore(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore) {
        String matchKey = calculateMatchKey(homeTeamName, awayTeamName);
        if (matches.containsKey(matchKey)) {
            matches.get(matchKey).setScore(homeTeamScore, awayTeamScore);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<Match> sortedMatches = new ArrayList<>(matches.values());
        sortedMatches.sort((a, b) -> Integer.compare(Arrays.stream(b.getScore()).sum(), Arrays.stream(a.getScore()).sum()));

        for (Match match : sortedMatches) {
            result.append(match.toString()).append('\n');
        }
        return result.toString();
    }
}