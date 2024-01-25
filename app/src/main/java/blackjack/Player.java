package blackjack;

public abstract class Player {

  protected Hand hand = new Hand();

  /**
   * Decides whether or not the player wants to hit and takes a card from the deck
   * if they do.
   * 
   * @param deck the deck to draw from
   * @return whether or not the player wants to hit
   */
  public abstract boolean decideToHit(Deck deck);

  /**
   * Returns player's hand value, with context for the type of player they are
   */
  public abstract String getPlayerHandDialog();

  protected void drawCard(Deck deck) {
    hand.addCard(deck.draw());
    if (deck.checkNeedsReshuffle()) {
      deck.reshuffle();
    }
  }

  public void discardHand(Deck deck) {
    hand.discardHand(deck);
  }

  public Hand getHand() {
    return hand;
  }
}
