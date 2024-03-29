package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardTest {

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

    @Test void whenGivenTeamNamesThatAreInSameMatch_andFinishedMatch_thenMatchInProgressShallReturnFalse() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        scoreboard.startMatch(homeTeamName, awayTeamName);
        assertTrue(scoreboard.matchInProgress(homeTeamName, awayTeamName));
        scoreboard.finishMatch(homeTeamName, awayTeamName);
        assertFalse(scoreboard.matchInProgress(homeTeamName, awayTeamName));
    }
    @Test void whenGivenTeamNamesThatArentInSameMatch_thenGetScoreShallReturnEmptyArray() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        int[] score = scoreboard.getScore(homeTeamName, awayTeamName);
        assertEquals(0, score.length);
    }
    @Test
    void whenGivenTeamNamesThatAreInSameMatch_thenGetScoreShallReturnCurrentScoreOfThatMatch() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        scoreboard.startMatch(homeTeamName, awayTeamName);
        int[] score = scoreboard.getScore(homeTeamName, awayTeamName);
        assertEquals(0, score[0]);
        assertEquals(0, score[1]);
    }

    @Test
    void whenGivenTeamNamesThatAreInSameMatch_andScoreUpdated_thenGetScoreShallReturnCurrentScoreOfThatMatch() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        scoreboard.startMatch(homeTeamName, awayTeamName);

        int homeTeamScore = 54;
        int awayTeamScore = 13;
        scoreboard.updateScore(homeTeamName, awayTeamName, homeTeamScore, awayTeamScore);

        int[] score = scoreboard.getScore(homeTeamName, awayTeamName);
        assertEquals(homeTeamScore, score[0]);
        assertEquals(awayTeamScore, score[1]);
    }
}
