package blackjack;

import java.util.Vector;

public class DeckStub extends Deck {

  public DeckStub() {
    super();
    super.cards = new Vector<Card>();
  }

  @Override
  public void reshuffle() {
    System.out.println("Reshuffling deck...");
    System.out.println();
    cards.addAll(discardPile);
    discardPile.clear();
  }

  public void addCard(Card card) {
    super.cards.add(card);
  }

}
