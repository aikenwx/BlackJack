package blackjack;

import java.util.Vector;

public class Player {

  private static final int BLACK_JACK_SCORE = 21;
  private static final int ACE_BONUS = 10;

  private Vector<Card> hand = new Vector<Card>();

  public void drawCard(Deck deck) {
    hand.add(deck.draw());
    if (deck.checkNeedsReshuffle()) {
      deck.reshuffle();
    }
  }

  public int getHandValue() {
    int total = 0;
    int aces = 0;

    for (Card card : hand) {
      if (card.getRank().equals("Ace")) {
        aces++;
      }
      total += card.getValue();
    }

    for (int i = 0; i < aces; i++) {
      if (total + ACE_BONUS <= BLACK_JACK_SCORE) {
        total += ACE_BONUS;
      }
    }

    return total;
  }

  public boolean checkBusted() {
    return getHandValue() > BLACK_JACK_SCORE;
  }

  public void discardHand(Deck deck) {
    deck.addCardsToDiscardPile(hand);
    hand.clear();
  }

  public boolean isBlackJack() {
    return getHandValue() == BLACK_JACK_SCORE;
  }

  public String showFirstCard() {
    return hand.get(0).toString();
  }

  public String toString() {
    String output = "";
    for (Card card : hand) {
      output += card.toString() + ", ";
    }
    return output;
  }

}
