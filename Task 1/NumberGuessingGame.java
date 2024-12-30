import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            // Prompt user for range
            System.out.print("Enter the lower bound of the range: ");
            int lowerBound = scanner.nextInt();

            System.out.print("Enter the upper bound of the range: ");
            int upperBound = scanner.nextInt();

            // Generate a random number within the specified range
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            System.out.println("I have picked a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");

            int guess;
            int attempts = 0;
            boolean isCorrect = false;
            int maxAttempts = 10; // Set a limit on the number of attempts

            // Game loop
            while (!isCorrect && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Score based on remaining attempts
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've used all your attempts. The number was " + randomNumber + ".");
            }

            roundsPlayed++;

            // Display score and rounds
            System.out.println("Rounds played: " + roundsPlayed);
            System.out.println("Total score: " + totalScore);

            // Option to play again
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing! Your final score is " + totalScore + " across " + roundsPlayed + " rounds. Goodbye.");
                break;
            }

            System.out.println("Starting a new round...\n");
        }

        scanner.close();
    }
}
