# A simple Black Jack game implemented in java

## Rules
1. The idea of Blackjack is to score higher than a Dealer’s hand without exceeding twentyone. Cards count their value, except face cards (jacks, queens, kings) count for ten, and
aces count for one. If you beat the Dealer, you get 10 points. If you get Blackjack (21 with
just two cards) and beat the Dealer, you get 15 points.
2. The game starts by giving two cards (from a standard 52 card deck) to the Dealer (one
face down) and two cards to the player. The player decides whether to Hit (get another
card) or Stay. The player can continue to hit as many if desired. If the player exceeds 21
before staying, it is a loss (-10 points). If the player does not exceed 21, it becomes the
dealer’s turn. The Dealer adds cards until 16 is exceeded. When this occurs, if the dealer
also exceeds 21 or if his total is less than the player’s, he loses. If the dealer total is greater than the player total (and under 21), the dealer wins. If the dealer and player have the same total, it is a Push (no points added or subtracted).
3. Aces count for either one or eleven, whichever benefits the player.
h. 
4. Cards from discard pile are reshuffled back in whenever there are fewer than fifteen (or so) cards remaining in the
deck. 

## How to run
* Jar file is located in the out/artifacts/BlackJack_jar folder
* Alternatively you can download it from releases: https://github.com/aikenwx/BlackJack/releases/tag/v1
* Run the jar file with the command: `java -jar BlackJack.jar`
* Enjoy!

## Implementation

### Class Diagram
![Simple Black Jack Class Diagram](./BlackJackClassDiagram.drawio.svg?raw=true "Simple Black Jack Class Diagram")

### Classes
To create the game, I created the following classes, following the OOP paradigm. The goal was to split responsibilities into different classes to make the code more modular and easier to maintain. The classes are as follows:

* Card
  * Represents a single card in a deck
  * Has a rank and a suit
* Deck
  * Represents the deck of 52 cards in a game of Black Jack
  * Cards can be drawn from the deck
  * Cards can be discarded into a pile which is reshuffled back into the deck when the deck runs low
* Player
  * Abstract class representing a player in a game of Black Jack
  * Players have a hand of cards
  * During play, they need to decide whether to hit or stay
* Dealer
  * Concrete class representing the dealer in a game of Black Jack
* User
  * Concrete class representing the user in a game of Black Jack (i.e the player)
* Hand
  * Represents a player's hand of cards
  * Handles calculating the value of the hand
* Game
  * Represents a game of Black Jack
  * Handles the player turns and scoring
* Scoreboard
  * Represents the scoreboard for a game of Black Jack, over multiple rounds of play
  * Calculates and keeps track of the player score, number of wins, losses, and pushes
