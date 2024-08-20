import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round + " starts!");
            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessed = true;
                    int score = (maxAttempts - attempts + 1) * 10; // More points for fewer attempts
                    totalScore += score;
                    System.out.println("Congratulations! You've guessed the correct number.");
                    System.out.println("You scored " + score + " points in this round.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }
        }

        System.out.println("\nGame over! Your total score is " + totalScore + " points.");

        scanner.close();
    }
}



