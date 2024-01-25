package blackjack;

import java.util.Vector;
import java.util.Collections;

public class Deck {
  protected Vector<Card> cards = new Vector<Card>();
  protected Vector<Card> discardPile = new Vector<Card>();

  public Deck() {
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        cards.add(new Card(suit, rank));
      }
    }
    Collections.shuffle(cards);
  }

  public void addCardsToDiscardPile(Vector<Card> cards) {
    discardPile.addAll(cards);
  }

  public void reshuffle() {
    System.out.println("Reshuffling deck...");
    System.out.println();
    cards.addAll(discardPile);
    discardPile.clear();
    Collections.shuffle(cards);

  }

  public Card draw() {
    return cards.remove(cards.size() - 1);
  }

  public boolean checkNeedsReshuffle() {
    return cards.size() < 15;
  }

}
