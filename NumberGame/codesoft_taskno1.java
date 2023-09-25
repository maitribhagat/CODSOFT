package javacode;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nI have selected a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess a number between " + lowerBound + " and " + upperBound + ".");
                } else if (userGuess < secretNumber) {
                    System.out.println("Higher! (" + (maxAttempts - attempts) + " attempts remaining)");
                } else if (userGuess > secretNumber) {
                    System.out.println("Lower! (" + (maxAttempts - attempts) + " attempts remaining)");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("You've run out of attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();
    }
}
