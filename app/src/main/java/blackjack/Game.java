package blackjack;

import java.util.Scanner;

public class Game {
  private Scoreboard scoreboard;
  private Deck deck;
  private Player player;
  private Player dealer;

  Scanner reader = new Scanner(System.in);

  public Game() {
    this.player = new User();
    this.dealer = new Dealer();
    this.deck = new Deck();
    this.scoreboard = new Scoreboard();
  }

  public Game(Deck deck, User player, Dealer dealer, Scoreboard scoreboard) {
    this.deck = deck;
    this.player = player;
    this.dealer = dealer;
    this.scoreboard = scoreboard;
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
    System.out.println("Dealing cards...\n");
    dealer.drawCard(deck);
    System.out.println("Dealer's up card is: " + dealer.getHand().toString());
    System.out.println();

    player.drawCard(deck);

    dealer.drawCard(deck);
    player.drawCard(deck);

    while (player.decideToHit(deck)) {
      if (player.getHand().checkBusted()) {
        System.out.println(player.getPlayerHandDialog());
        System.out.println("You busted! You lose!");
        System.out.println();
        scoreboard.updateScoreForPlayerLoss();
        return concludeGame(player, dealer, deck);
      }
    }

    while (dealer.decideToHit(deck)) {
      System.out.println("Dealer drawing card...\n");
      if (dealer.getHand().checkBusted()) {
        System.out.println(dealer.getPlayerHandDialog());
        System.out.println("Dealer busted! You win!");
        System.out.println();
        scoreboard.updateScoreForPlayerWin();
        return concludeGame(player, dealer, deck);
      }
    }

    checkForWin(player, dealer);

    return concludeGame(player, dealer, deck);
  }

  /**
   * Checks for a win and updates the scoreboard accordingly
   * 
   * @param player the player
   * @param dealer the dealer
   */
  private void checkForWin(Player player, Player dealer) {
    System.out.println("Opening hands:\n");

    System.out.println(dealer.getPlayerHandDialog());
    System.out.println(player.getPlayerHandDialog());

    Hand playerHand = player.getHand();
    Hand dealerHand = dealer.getHand();

    if (playerHand.getHandValue() > dealerHand.getHandValue()) {

      scoreboard.updateScoreForPlayerWin();
      System.out.println("You win!");
    } else if (playerHand.getHandValue() < dealerHand.getHandValue()) {

      System.out.println("You lose!");
      scoreboard.updateScoreForPlayerLoss();
    } else {

      System.out.println("It's a tie!");
      scoreboard.updateScoreForTie();
    }
    System.out.println();
  }

  private boolean concludeGame(Player player, Player dealer, Deck deck) {
    player.discardHand(deck);
    dealer.discardHand(deck);

    System.out.println(scoreboard.toString());
    System.out.println("continue playing? (y/n)");
    String input = reader.nextLine();
    while (!input.equals("y") && !input.equals("n")) {
      System.out.println("Invalid input. Please enter 'y' or 'n'.");
      input = reader.nextLine();
    }
    System.out.println();

    if (input.equals("y")) {
      return true;
    } else {
      return false;
    }
  }
}