package com.sportradar.codingexercise;
import java.util.*;

public class Scoreboard {
    Map<String, Match> matches = new HashMap<>();
    List<String> orderOfMatches = new ArrayList<>();

    private String calculateMatchKey(String homeTeamName, String awayTeamName) {
        return STR."\{homeTeamName}_\{awayTeamName}";
    }

    public void startMatch(String homeTeamName, String awayTeamName) {
        if (!matchInProgress(homeTeamName, awayTeamName)) {
            String matchKey = calculateMatchKey(homeTeamName, awayTeamName);
            matches.put(matchKey, new Match(homeTeamName, awayTeamName));
            orderOfMatches.add(matchKey);
        }
    }

    public boolean matchInProgress(String homeTeamName, String awayTeamName) {
        return matches.containsKey(calculateMatchKey(homeTeamName, awayTeamName));
    }

    public void finishMatch(String homeTeamName, String awayTeamName) {
        if (matchInProgress(homeTeamName, awayTeamName)) {
            matches.remove(calculateMatchKey(homeTeamName, awayTeamName));
        }
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
        List<Map.Entry<String, Match>> sortedMatches = new ArrayList<>(matches.entrySet());
        sortedMatches.sort((a, b) -> {
            int compareScore = Integer.compare(Arrays.stream(b.getValue().getScore()).sum(), Arrays.stream(a.getValue().getScore()).sum());
            return (compareScore != 0) ? compareScore : Integer.compare(orderOfMatches.indexOf(b.getKey()), orderOfMatches.indexOf(a.getKey()));
        });

        for (Map.Entry<String, Match> entry : sortedMatches) {
            result.append(entry.getValue().toString()).append('\n');
        }
        return result.toString();
    }
}