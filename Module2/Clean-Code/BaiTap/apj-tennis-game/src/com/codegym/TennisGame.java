package com.codegym;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        if (playerScore1 == playerScore2) {
            return evenScore(playerScore1);
        } else if (playerScore1 >= 4 || playerScore2 >= 4) {
            return advantageOrWin(playerScore1, playerScore2);
        } else {
            return normalScore(playerScore1, playerScore2);
        }
    }


    private static String evenScore(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static String advantageOrWin(int playerScore1, int playerScore2) {
        int diff = playerScore1 - playerScore2;
        if (diff == 1) return "Advantage player1";
        if (diff == -1) return "Advantage player2";
        if (diff >= 2) return "Win for player1";
        return "Win for player2";
    }

    private static String normalScore(int playerScore1, int playerScore2) {
        return scoreToString(playerScore1) + "-" + scoreToString(playerScore2);
    }

    private static String scoreToString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}