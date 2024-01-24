package blackjack;

public enum Suit {
  HEARTS("Hearts"), DIAMONDS("Diamonds"), CLUBS("Clubs"), SPADES("Spades");

  private String name;

  Suit(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}