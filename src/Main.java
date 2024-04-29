import com.dyma.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Class of the entrypoint of the Guess Game.
 */
public class Main {

    /**
     * Entry point of the Guess Game. Contains the main algorithm of the game.
     */
    public static void main(String[] args) {
        final var random = new Random();
        final var words = "abuser crottes fleches continental babiole etoile bougie coup coeur malade".split(" ");
        final var lifePoints = 10;
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, lifePoints);

        System.out.println("Début du jeu.");

        while(true) {
            System.out.println(game);
            final var letter = scanLetter("Entrez une lettre : ");

            game.guessLetter(letter);
            if (game.isLost()){
                System.out.println("Perdu !");
            }
            if (game.isWon()){
                System.out.println("Gagné !");
            }
            if (game.isWon() || game.isLost()) {
                System.out.println(game);
                var replayAnswer = scanLetter("Rejouer ? (y, Y, o, O)");
                if (replayAnswer == 'y' || replayAnswer == 'Y' || replayAnswer == 'o' || replayAnswer == 'O')
                {
                    wordToGuess = words[random.nextInt(words.length-1)];
                    game = new GuessGame(wordToGuess, lifePoints);
                } else {
                    break;
                }
            }
        }
    }

    private static char scanLetter(String question){
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do {
            System.out.println(question);
            var input = scanner.nextLine();
            if (input.length() == 1) {
                letter = input.charAt(0);
            }
        } while (letter == null);
        return letter;
    }
}