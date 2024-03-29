package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;

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
}
