package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {
    @Test
    public void matchCanHaveAHomeTeam() {
        Match match = new Match();
        match.setHomeTeam("HomeTeam");
    }

    @Test
    public void matchCanHaveAnAwayTeam() {
        Match match = new Match();
        match.setAwayTeam("AwayTeam");
    }
    @Test
    public void whenHomeTeamNameNotSet_thenEmptyByDefault()
    {
        Match match = new Match();
        assertEquals("", match.getHomeTeam());
    }

    @Test
    public void whenAwayTeamNameNotSet_thenEmptyByDefault()
    {
        Match match = new Match();
        assertEquals("", match.getAwayTeam());
    }

    @Test
    public void whenHomeTeamNameSet_thenCanGetThatHomeTeamName()
    {
        Match match = new Match();
        String teamName = "HomeTeam";
        match.setHomeTeam(teamName);
        assertEquals(teamName, match.getHomeTeam());
    }

    @Test
    public void whenAwayTeamNameSet_thenCanGetThatAwayTeamName()
    {
        Match match = new Match();
        String teamName = "HomeTeam";
        match.setAwayTeam(teamName);
        assertEquals(teamName, match.getAwayTeam());
    }
}