package blackjack;

import java.util.Vector;

/**
 * This class represents the hand held by a player
 */
public class Hand {

  private static final int BLACK_JACK_SCORE = 21;
  private static final int ACE_BONUS = 10;

  Vector<Card> cards;

  public Hand() {
    cards = new Vector<Card>();
  }

  /**
   * Adds a card to the hand
   * 
   * @param card to be added
   */
  public void addCard(Card card) {
    cards.add(card);
  }

  /**
   * Returns the total value of the hand
   * 
   * @return value of the hand
   */
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

  /**
   * Checks if the hand has exceeded 21 points, i.e. a bust
   * 
   * @return true if the hand is a bust, false otherwise
   */
  public boolean checkBusted() {
    return getHandValue() > BLACK_JACK_SCORE;
  }

  /**
   * Discards the hand to the deck's discard pile
   * 
   * @param deck to discard the hand to
   */
  public void discardHand(Deck deck) {
    deck.addCardsToDiscardPile(cards);
    cards.clear();
  }

  /**
   * Checks if the hand is a blackjack, i.e. 21 points
   * 
   * @return true if the hand is a blackjack, false otherwise
   */
  public boolean isBlackJack() {
    return getHandValue() == BLACK_JACK_SCORE;
  }

  @Override
  public String toString() {
    String handString = "";
    for (Card card : cards) {
      handString += card.toString() + ",";
    }
    return handString;
  }
}
