package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardTest {
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

    @Test
    void whenGivenTeamNamesThatAreInSameMatch_thenStartMatchShallNotResetTheMatch() {
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

        scoreboard.startMatch(homeTeamName, awayTeamName);
        int[] scoreAfterNextStartMatch = scoreboard.getScore(homeTeamName, awayTeamName);
        assertEquals(homeTeamScore, scoreAfterNextStartMatch[0]);
        assertEquals(awayTeamScore, scoreAfterNextStartMatch[1]);
    }


    @Test
    void testToString_whenItsCalledOnEmptyScoreboard_thenItShallReturnNothing() {
        Scoreboard scoreboard = new Scoreboard();
        assertEquals("", scoreboard.toString());
    }

    @Test
    void testToString_whenItsCalledWhileHavingOnlyOneMatch_thenItShallReturnTheSameAsToStringOfTheMatchPlusNewLine() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        int homeTeamScore = 65;
        int awayTeamScore = 123;
        scoreboard.startMatch(homeTeamName, awayTeamName);
        scoreboard.updateScore(homeTeamName, awayTeamName, homeTeamScore, awayTeamScore);

        Match match = new Match(homeTeamName, awayTeamName);
        match.setScore(homeTeamScore, awayTeamScore);

        assertEquals(match.toString() + '\n', scoreboard.toString());
    }

    @Test
    void testToString_whenItsCalledWhileHavingMultipleMatches_thenItShallReturnResultOfEachMatchToStringOrderedByTopTotalScoreOfTheMatch() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        String homeTeamNameSecondMatch = "HomeTeamSecondMatch";
        String awayTeamNameSecondMatch = "AwayTeamSecondMatch";
        String homeTeamNameThirdMatch = "HomeTeamThirdMatch";
        String awayTeamNameThirdMatch = "AwayTeamThirdMatch";
        int homeTeamScore = 25;
        int awayTeamScore = 23;
        int homeTeamScoreSecondMatch = 12;
        int awayTeamScoreSecondMatch = 13;
        int homeTeamScoreThirdMatch = 45;
        int awayTeamScoreThirdMatch = 65;

        scoreboard.startMatch(homeTeamName, awayTeamName);
        scoreboard.updateScore(homeTeamName, awayTeamName, homeTeamScore, awayTeamScore);

        scoreboard.startMatch(homeTeamNameSecondMatch, awayTeamNameSecondMatch);
        scoreboard.updateScore(homeTeamNameSecondMatch, awayTeamNameSecondMatch, homeTeamScoreSecondMatch, awayTeamScoreSecondMatch);

        scoreboard.startMatch(homeTeamNameThirdMatch, awayTeamNameThirdMatch);
        scoreboard.updateScore(homeTeamNameThirdMatch, awayTeamNameThirdMatch, homeTeamScoreThirdMatch, awayTeamScoreThirdMatch);

        Match match = new Match(homeTeamName, awayTeamName);
        match.setScore(homeTeamScore, awayTeamScore);

        Match secondMatch = new Match(homeTeamNameSecondMatch, awayTeamNameSecondMatch);
        secondMatch.setScore(homeTeamScoreSecondMatch, awayTeamScoreSecondMatch);

        Match thirdMatch = new Match(homeTeamNameThirdMatch, awayTeamNameThirdMatch);
        thirdMatch.setScore(homeTeamScoreThirdMatch, awayTeamScoreThirdMatch);

        assertEquals(STR."\{thirdMatch.toString()}\n\{match.toString()}\n\{secondMatch.toString()}\n", scoreboard.toString());
    }

    @Test
    void testToString_whenItsCalledWhileHavingMultipleMatches_thenItShallReturnResultOfEachMatchToStringOrderedByTheMostRecentlyStartedMatchIfTopTotalScoreTied() {
        Scoreboard scoreboard = new Scoreboard();
        String homeTeamName = "HomeTeam";
        String awayTeamName = "AwayTeam";
        String homeTeamNameSecondMatch = "HomeTeamSecondMatch";
        String awayTeamNameSecondMatch = "AwayTeamSecondMatch";
        String homeTeamNameThirdMatch = "HomeTeamThirdMatch";
        String awayTeamNameThirdMatch = "AwayTeamThirdMatch";
        int homeTeamScore = 44;
        int awayTeamScore = 66;
        int homeTeamScoreSecondMatch = 25;
        int awayTeamScoreSecondMatch = 25;
        int homeTeamScoreThirdMatch = 10;
        int awayTeamScoreThirdMatch = 40;

        scoreboard.startMatch(homeTeamName, awayTeamName);
        scoreboard.updateScore(homeTeamName, awayTeamName, homeTeamScore, awayTeamScore);

        scoreboard.startMatch(homeTeamNameSecondMatch, awayTeamNameSecondMatch);
        scoreboard.updateScore(homeTeamNameSecondMatch, awayTeamNameSecondMatch, homeTeamScoreSecondMatch, awayTeamScoreSecondMatch);

        scoreboard.startMatch(homeTeamNameThirdMatch, awayTeamNameThirdMatch);
        scoreboard.updateScore(homeTeamNameThirdMatch, awayTeamNameThirdMatch, homeTeamScoreThirdMatch, awayTeamScoreThirdMatch);

        Match match = new Match(homeTeamName, awayTeamName);
        match.setScore(homeTeamScore, awayTeamScore);

        Match secondMatch = new Match(homeTeamNameSecondMatch, awayTeamNameSecondMatch);
        secondMatch.setScore(homeTeamScoreSecondMatch, awayTeamScoreSecondMatch);

        Match thirdMatch = new Match(homeTeamNameThirdMatch, awayTeamNameThirdMatch);
        thirdMatch.setScore(homeTeamScoreThirdMatch, awayTeamScoreThirdMatch);

        assertEquals(STR."\{match.toString()}\n\{thirdMatch.toString()}\n\{secondMatch.toString()}\n", scoreboard.toString());
    }

    @Test
    void testToString_customerAcceptanceTest() {
        Scoreboard scoreboard = new Scoreboard();
        String[] homeTeamNames = {"Mexico", "Spain", "Germany", "Uruguay", "Argentina"};
        String[] awayTeamNames = {"Canada", "Brazil", "France", "Italy", "Australia"};

        int[] homeTeamScores = {0, 10, 2, 6, 3};
        int[] awayTeamScores = {5, 2, 2, 6, 1};

        for (int i = 0; i < homeTeamNames.length; i++)
        {
            scoreboard.startMatch(homeTeamNames[i], awayTeamNames[i]);
            scoreboard.updateScore(homeTeamNames[i], awayTeamNames[i], homeTeamScores[i], awayTeamScores[i]);
        }

        String expectedString = """
                Uruguay 6 - Italy 6
                Spain 10 - Brazil 2
                Mexico 0 - Canada 5
                Argentina 3 - Australia 1
                Germany 2 - France 2
                """;

        assertEquals(expectedString, scoreboard.toString());
    }
}
