package com.codegym;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = StringBuilder();
        int currentScore = 0;
        if (player1Score == player2Score) {
            score = getDrawScore(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getAdvantageOrWinscore(player1Score, player2Score);
        } else {
            score = getIndividualScore(player1Score, player2Score, score);
        }
        return score;
    }

    private static String StringBuilder() {
        String score = "";
        return score;
    }


    private static String getIndividualScore(int player1Score, int player2Score, String score) {
        int currentScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) currentScore = player1Score;
            else {
                score += "-";
                currentScore = player2Score;
            }
            score = getCurrentScore(score, currentScore);
        }
        return score;
    }

    private static String getCurrentScore(String score, int currentScore) {
        switch (currentScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private static String getAdvantageOrWinscore(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String getDrawScore(int player1Score) {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}