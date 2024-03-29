package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;

public class ScoreboardTest {
    @Test
    public void canAddMatchToScoreboard() {
        Scoreboard scoreboard = new Scoreboard();
        Match match = new Match();
        scoreboard.Add(match);
    }
}
