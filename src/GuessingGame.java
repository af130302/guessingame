/*
Java game "Guess a Number" that allows user to guess a random number that has been generated.

source: https://hackr.io/blog/java-projects
*/

import java.util.Scanner;

public class GuessingGame {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        int computerNumber = (int) (Math.random() * MAX_VALUE + MIN_VALUE);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter a guess between " + MIN_VALUE + " and " + MAX_VALUE + ": ");
            String response = scanner.nextLine();

            try {
                userAnswer = Integer.parseInt(response);
                System.out.println(determineGuess(userAnswer, computerNumber, count));
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (userAnswer != computerNumber);
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer < MIN_VALUE || userAnswer > MAX_VALUE) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        } else {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
    }
}