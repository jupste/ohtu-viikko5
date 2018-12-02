package ohtu;

public class TennisGame {

    private static String[] evengame = new String[]{"Love-All", "Fifteen-All",
        "Thirty-All", "Forty-All", "Deuce"};
    private static String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private static int FORTYPOINTS = 4;
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String playerPosition(int minus) {
        if (minus == 1) {
            return "Advantage player1";
        } else if (minus == -1) {
            return "Advantage player2";
        } else if (minus >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public String getScore() {
        String score = "";
        int tempScore;
        if (m_score1 == m_score2) {
            return evengame[m_score1];
        } else if (m_score1 >= FORTYPOINTS || m_score2 >= FORTYPOINTS) {
            return playerPosition(m_score1 - m_score2);
        } else {
            return scores[m_score1] + "-" + scores[m_score2];
        }
    }

    public static void main(String[] args) {

    }
}
