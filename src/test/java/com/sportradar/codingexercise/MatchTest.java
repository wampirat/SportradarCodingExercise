package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {
    @Test
    public void whenHomeTeamNameNotSet_thenEmptyByDefault() {
        Match match = new Match();
        assertEquals("", match.getHomeTeam());
    }

    @Test
    public void whenAwayTeamNameNotSet_thenEmptyByDefault() {
        Match match = new Match();
        assertEquals("", match.getAwayTeam());
    }

    @Test
    public void whenHomeTeamNameSet_thenCanGetThatHomeTeamName() {
        Match match = new Match();
        String teamName = "HomeTeam";
        match.setHomeTeam(teamName);
        assertEquals(teamName, match.getHomeTeam());
    }

    @Test
    public void whenAwayTeamNameSet_thenCanGetThatAwayTeamName() {
        Match match = new Match();
        String teamName = "AwayTeam";
        match.setAwayTeam(teamName);
        assertEquals(teamName, match.getAwayTeam());
    }

    @Test
    public void whenTeamNamesProvidedToConstructor_thenCanGetThoseTeamNames() {
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        Match match = new Match(homeTeamName, awayTeamName);
        assertEquals(homeTeamName, match.getHomeTeam());
        assertEquals(awayTeamName, match.getAwayTeam());
    }

    @Test
    public void whenNewMatchCreated_thenInitialScoreShallBeZeroToZero() {
        Match match = new Match();
        int[] score = match.getScore();
        assertEquals(2, score.length);
        assertEquals(0, score[0]);
        assertEquals(0, score[1]);
    }

    @Test
    public void whenMatchScoreUpdated_thenCanGetNewScore() {
        Match match = new Match();
        int homeTeamScore = 3;
        int awayTeamScore = 14;
        match.setScore(homeTeamScore, awayTeamScore);
        int[] score = match.getScore();
        assertEquals(homeTeamScore, score[0]);
        assertEquals(awayTeamScore, score[1]);
    }

    @Test
    public void testToString_whenItsCalledOnDefaultMatch() {
        Match match = new Match();
        assertEquals("0 - 0", match.toString());
    }

    @Test
    public void testToString_whenItsCalledWithOnlyHomeTeamNamed_andWithInitialScore() {
        String homeTeamName = "HomeTeam";
        Match match = new Match(homeTeamName, "");
        assertEquals(STR."\{homeTeamName} 0 - 0", match.toString());
    }

    @Test
    public void testToString_whenItsCalledWithOnlyAwayTeamNamed_andWithInitialScore() {
        String awayTeamName = "AwayTeam";
        Match match = new Match("", awayTeamName);
        assertEquals(STR."0 - \{awayTeamName} 0", match.toString());
    }

    @Test
    public void testToString_whenItsCalledWithBothTeamsNamed_andWithInitialScore() {
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        Match match = new Match(homeTeamName, awayTeamName);
        assertEquals(STR."\{homeTeamName} 0 - \{awayTeamName} 0", match.toString());
    }

    @Test
    public void testToString_whenItsCalledWithBothTeamsNamed_andWithUpdatedScore() {
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        Match bothTeamsNamed = new Match(homeTeamName, awayTeamName);
        int homeTeamScore = 54;
        int awayTeamScore = 213;
        bothTeamsNamed.setScore(homeTeamScore, awayTeamScore);
        assertEquals(STR."\{homeTeamName} \{homeTeamScore} - \{awayTeamName} \{awayTeamScore}", bothTeamsNamed.toString());
    }
}
