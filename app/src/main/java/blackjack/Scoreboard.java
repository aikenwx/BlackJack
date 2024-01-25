package blackjack;

public class Scoreboard {
  public static final int WIN_POINTS = 15;
  public static final int LOSS_POINTS = 10;

  private int playerScore;
  private int playerWins;
  private int playerLosses;
  private int ties;

  public Scoreboard() {
    this.playerScore = 0;
  }

  public void updateScoreForPlayerWin() {
    playerScore += WIN_POINTS;
    playerWins++;
  }

  public void updateScoreForPlayerLoss() {
    playerScore -= LOSS_POINTS;
    playerLosses++;
  }

  public void updateScoreForTie() {
    ties++;
  }

  public String toString() {
    return "Score: " + playerScore + " points, (" + playerWins + " wins, " + playerLosses + " losses, " + ties
        + " ties)";
  }
}
