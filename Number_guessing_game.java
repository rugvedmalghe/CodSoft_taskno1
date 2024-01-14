import java.util.Random;
import java.util.Scanner;

public class Number_guessing_game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 8;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println(
                    "\nRound " + (rounds + 1) + ": Guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Please enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Please Try again.");
                } else {
                    System.out.println("Too high! Please Try again.");
                }
            }

            if (guessedCorrectly) {
                System.out.println("YAY! You guessed the correct number in " + attempts + " attempts.");
                score += maxAttempts - attempts + 1;
            } else {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "
                        + targetNumber);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("no")) {
                break;
            }

            rounds++;

        } while (true);

        System.out.println("Thanks for playing! Your final score: " + score);
    }
}
