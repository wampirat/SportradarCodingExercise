package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void whenGivenTeamNamesThatArentInScoreBoard_thenMatchInProgressShallReturnFalse() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        assertFalse(scoreboard.matchInProgress(homeTeamName, awayTeamName));
    }
    @Test
    public void whenGivenTeamNamesThatArentInSameMatch_thenMatchInProgressShallReturnFalse() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";

        String homeTeamNameSecondMatch = "HomeTeamSecondMatch";
        String awayTeamNameSecondMatch = "AwayTeamSecondMatch";

        scoreboard.startMatch(homeTeamName, awayTeamName);
        scoreboard.startMatch(homeTeamNameSecondMatch, awayTeamNameSecondMatch);

        assertFalse(scoreboard.matchInProgress(homeTeamNameSecondMatch, awayTeamName));
        assertFalse(scoreboard.matchInProgress(homeTeamName, awayTeamNameSecondMatch));
    }

    @Test
    public void whenGivenTeamNamesThatAreInSameMatch_thenMatchInProgressShallReturnTrue() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        scoreboard.startMatch(homeTeamName, awayTeamName);
        assertTrue(scoreboard.matchInProgress(homeTeamName, awayTeamName));
    }
}
