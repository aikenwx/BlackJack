package blackjack;

public class Game {
  private static final int DEALER_HIT_VALUE = 16;
  private Scoreboard scoreboard;
  private Deck deck;
  private Player player;
  private Player dealer;

  public Game() {
    this.player = new Player();
    this.dealer = new Player();
    this.deck = new Deck();
    this.scoreboard = new Scoreboard();
  }

  public void startSession() {
    System.out.println("Welcome to Blackjack!");
    System.out.println("Your starting score is 0 points.");
    System.out.println("You will gain 15 points for a win, and lose 10 points for a loss.");
    System.out.println("You will gain 0 points for a tie.");
    System.out.println("Let's play!");
    System.out.println();


    while (playGame()) {
    }

    System.out.println("Thanks for playing!");
  }

  private boolean playGame() {
    System.out.println("----------------------------------------------------------------");

    dealer.drawCard(deck);
    player.drawCard(deck);

    dealer.drawCard(deck);
    player.drawCard(deck);

    boolean playerStay = false;
    System.out.println("Dealer's up card is: " + dealer.showFirstCard());
    System.out.println();

    while (!playerStay) {
      printPlayerHandValue(player);
      System.out.println("Would you like to hit or stay? (h/s)");

      String input = System.console().readLine();
      while (!input.equals("h") && !input.equals("s")) {
        System.out.println("Invalid input. Please enter 'h' or 's'.");
        input = System.console().readLine();
      }
      System.out.println();

      if (input.equals("h")) {
        player.drawCard(deck);
        if (player.checkBusted()) {
          printPlayerBustedMessage(player);
          scoreboard.updateScoreForPlayerLoss();
          return concludeGame(player, dealer, deck);
        }
      } else {
        playerStay = true;
      }
    }


    while (dealer.getHandValue() <= DEALER_HIT_VALUE) {
      dealer.drawCard(deck);
      if (dealer.checkBusted()) {
        printDealerBustedMessage(dealer);
        scoreboard.updateScoreForPlayerWin();
        return concludeGame(player, dealer, deck);
      }
    }

    checkForWin(player, dealer);

    return concludeGame(player, dealer, deck);
  }

  private void checkForWin(Player player, Player dealer) {
    if (player.getHandValue() > dealer.getHandValue()) {
      printDealerHand(dealer);
      printPlayerHandValue(player);
      scoreboard.updateScoreForPlayerWin();
      System.out.println("You win!");
    } else if (player.getHandValue() < dealer.getHandValue()) {
      printDealerHand(dealer);
      printPlayerHandValue(player);
      System.out.println("You lose!");
      scoreboard.updateScoreForPlayerLoss();
    } else {
      printDealerHand(dealer);
      printPlayerHandValue(player);
      System.out.println("It's a tie!");
      scoreboard.updateScoreForTie();
    }
    System.out.println();
  }

  private boolean concludeGame(Player player, Player dealer, Deck deck) {
    player.discardHand(deck);
    dealer.discardHand(deck);

    System.out.println("Your current score is: " + scoreboard.toString());
    System.out.println("continue playing? (y/n)");
    String input = System.console().readLine();
    while (!input.equals("y") && !input.equals("n")) {
      System.out.println("Invalid input. Please enter 'y' or 'n'.");
      input = System.console().readLine();
    }
    System.out.println();

    if (input.equals("y")) {
      return true;
    } else {
      return false;
    }
  }

  private void printDealerHand(Player dealer) {
    System.out.println("Dealer's hand is: " + dealer.toString());
    System.out.println("Dealer's hand value is: " + dealer.getHandValue());
    System.out.println();

    if (dealer.isBlackJack()) {
      System.out.println("Blackjack!");
      System.out.println();
    }
  }

  private void printPlayerHandValue(Player player) {
    System.out.println("Your hand is: " + player.toString());
    System.out.println("Your hand value is: " + player.getHandValue());
    System.out.println();

    if (player.isBlackJack()) {
      System.out.println("Blackjack!");
      System.out.println();
    }
   
  }

  private void printPlayerBustedMessage(Player player) {
    printPlayerHandValue(player);
    System.out.println("You busted! You lose!");
    System.out.println();
  }

  private void printDealerBustedMessage(Player dealer) {
    printDealerHand(dealer);
    System.out.println("Dealer busted! You win!");
    System.out.println();
  }

}