package blackjack;

public class Dealer extends Player {

  private static final int DEALER_HIT_VALUE = 16;

  public Dealer() {
    super();
  }

  @Override
  public boolean decideToHit(Deck deck) {
    if (this.hand.getHandValue() < DEALER_HIT_VALUE) {
      this.drawCard(deck);
      return true;
    }
    return false;
  }

  @Override
  public String getPlayerHandDialog() {
    String context = "Dealer's hand: " + super.hand.toString() + "\nDealer's hand value: "
        + this.hand.getHandValue() + "\n";

    if (this.hand.isBlackJack()) {
      context += "\nDealer has gotten a Blackjack!\n";
    }

    return context;
  }

}
