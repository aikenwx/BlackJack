package blackjack;

public class User extends Player {
  public User() {
    super();
  }

  @Override
  public boolean decideToHit(Deck deck) {
    System.out.println(getPlayerHandDialog());

    System.out.println("Would you like to hit or stay? (h/s)");

    String input = System.console().readLine();
    while (!input.equals("h") && !input.equals("s")) {
      System.out.println("Invalid input. Please enter 'h' or 's'.");
      input = System.console().readLine();
    }
    System.out.println();

    if (input.equals("h")) {
      System.out.println("Drawing card...\n");
      this.drawCard(deck);
      return true;
    } else {
      System.out.println("Staying...\n");
      return false;
    }
  }

  @Override
  public String getPlayerHandDialog() {
    String context = "Your hand: " + super.hand.toString() + "\nYour hand's value: "
        + super.hand.getHandValue() + "\n";

    if (super.hand.isBlackJack()) {
      context += "\nYou have gotten a Blackjack!\n";
    }

    return context;
  }
}
