import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Generate random number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;

        int guess;
        int attempts = 0;
        int maxAttempts = 10;

        System.out.println("===== NUMBER GUESSING GAME =====");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have only " + maxAttempts + " attempts.");

        // Loop until attempts finish
        while (attempts < maxAttempts) {

            System.out.print("\nEnter your guess: ");

            // Handle invalid input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // clear invalid input
                continue;
            }

            guess = sc.nextInt();
            attempts++;

            // Check guess
            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                System.out.println("Attempts used: " + attempts);
                break;
            }
            else if (guess > secretNumber) {
                System.out.println("Too High!");
            }
            else {
                System.out.println("Too Low!");
            }

            // Remaining attempts
            System.out.println("Remaining Attempts: " + (maxAttempts - attempts));
        }

        // If user fails
        if (attempts == maxAttempts) {
            System.out.println("\nGame Over!");
            System.out.println("The correct number was: " + secretNumber);
        }

        sc.close();
    }
}