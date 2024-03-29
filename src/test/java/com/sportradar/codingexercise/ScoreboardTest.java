package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;

public class ScoreboardTest {
    @Test
    public void canAddMatchToScoreboard() {
        Scoreboard scoreboard = new Scoreboard();
        Match match = new Match();
        scoreboard.Add(match);
    }

    @Test
    public void canStartAMatch() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        scoreboard.startMatch(homeTeamName, awayTeamName);
    }
}
