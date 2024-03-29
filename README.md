# Live Football World Cup Scoreboard Library

This is a simple Java library for managing and displaying live football World Cup scores.

## Overview

This library provides functionality to start new matches, update scores, finish matches, and get a summary of ongoing matches ordered by their total score.

## Usage

### Starting a New Match

To start a new match, use the `startMatch` method with the home team and away team names:

```java
Scoreboard scoreboard = new Scoreboard();
scoreboard.startMatch("HomeTeam", "AwayTeam");
```

this will add a `Match` to the `Scoreboard` with assumed initial score 0 - 0

### Updating Scores

To update scores for a match, use the `updateScore` method with the home team score and away team score:

```java
scoreboard.updateScore("HomeTeam", "AwayTeam", 3, 1);
```

### Finishing a Match

To finish a match, use the `finishMatch` method:

```java
scoreboard.finishMatch("HomeTeam", "AwayTeam");
```

this will remove a `Match` from the `Scoreboard`

### Getting Summary

To get a summary of ongoing matches ordered by their total score, use the `getSummary` method:

```java
String summary = scoreboard.getSummary();
System.out.println(summary);
```

Note: if two matches have the same total score, then those matches will be additionally ordered by the most recently started `Match` in the `Scoreboard` 

## Example

```java
Scoreboard scoreboard = new Scoreboard();
scoreboard.startMatch("Mexico", "Canada");
scoreboard.updateScore("Mexico", "Canada", 0, 5);
scoreboard.startMatch("Spain", "Brazil");
scoreboard.updateScore("Spain", "Brazil", 10, 2);
scoreboard.startMatch("Germany", "France");
scoreboard.updateScore("Germany", "France", 2, 2);
scoreboard.startMatch("Uruguay", "Italy");
scoreboard.updateScore("Spain", "Brazil", 6, 6);
scoreboard.startMatch("Argentina", "Australia");
scoreboard.updateScore("Argentina", "Australia", 3, 1);

String summary = scoreboard.getSummary();
System.out.println(summary);
```

Output:

```
Uruguay 6 - Italy 6
Spain 10 - Brazil 2
Mexico 0 - Canada 5
Argentina 3 - Australia 1
Germany 2 - France 2
```
