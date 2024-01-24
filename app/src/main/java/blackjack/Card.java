package blackjack;

public class Card {
  private Suit suit;
  private Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public String getSuit() {
    return suit.toString();
  }

  public String getRank() {
    return rank.toString();
  }

  public int getValue() {
    return rank.getValue();
  }

  public String toString() {
    return rank + " of " + suit;
  }
}
