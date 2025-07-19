import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRoundsWon = 0;
        int totalAttemptsMade = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int min = 1;
            int max = 100;
            int generatedNumber = random.nextInt((max - min) + 1) + min;
            int attempts = 0;
            int maxAttempts = 4; // Limiting the number of attempts
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess;

                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next();
                    System.out.print("Enter your guess: ");
                }
                userGuess = scanner.nextInt();
                attempts++;
                totalAttemptsMade++; 
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " correctly!");
                    System.out.println("It took you " + attempts + " attempt(s).");
                    guessedCorrectly = true;
                    totalRoundsWon++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else { 
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts! The number was " + generatedNumber + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("You won " + totalRoundsWon + " round(s).");
        System.out.println("Total attempts made across all rounds: " + totalAttemptsMade);
    }
}