package org.example.tennis;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score) return equalScore(player1Score);
        else if (player1Score >= 4 || player2Score >= 4) return advantageOrWinScore(player1Score - player2Score);
        else return otherScores(player1Score, player2Score);
    }

    private String otherScores(int player1Score, int player2Score) {
        return playerScoreToText(player1Score) + "-" + playerScoreToText(player2Score);
    }

    private static String playerScoreToText(int playerScore) {
        return switch (playerScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

    private static String advantageOrWinScore(int scoreDifference) {
        return switch (scoreDifference) {
            case 1 -> "Advantage player1";
            case -1 -> "Advantage player2";
            case 2, 3, 4 -> "Win for player1";
            default -> "Win for player2";
        };
    }

    private static String equalScore(int score) {
        return switch (score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
