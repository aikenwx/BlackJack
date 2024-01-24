package blackjack;

public class Scoreboard {
  private int playerScore;
  private int playerWins;
  private int playerLosses;
  private int ties;

  public Scoreboard() {
    this.playerScore = 0;
  }

  public void updateScoreForPlayerWin() {
    playerScore+=15;
    playerWins++;
  }

  public void updateScoreForPlayerLoss() {
    playerScore-=10;
    playerLosses++;
  }

  public void updateScoreForTie() {
    ties++;
  }

  public String toString() {
    return "Score: " + playerScore + " points, (" + playerWins + " wins, " + playerLosses + " losses, " + ties + " ties)";
  }
}
