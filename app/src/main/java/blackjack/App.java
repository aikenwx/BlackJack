/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package blackjack;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startSession();
    }
}
