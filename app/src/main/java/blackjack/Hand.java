package blackjack;

import java.util.Vector;

public class Hand {

  private static final int BLACK_JACK_SCORE = 21;
  private static final int ACE_BONUS = 10;

  Vector<Card> cards;

  public Hand() {
    cards = new Vector<Card>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public int getHandValue() {
    int total = 0;
    int aces = 0;

    for (Card card : cards) {
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
    deck.addCardsToDiscardPile(cards);
    cards.clear();
  }

  public boolean isBlackJack() {
    return getHandValue() == BLACK_JACK_SCORE;
  }

  public String toString() {
    String handString = "";
    for (Card card : cards) {
      handString += card.toString() + ",";
    }
    return handString;
  }
}
