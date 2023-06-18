/*
Java game "Guess a Number" that allows user to guess a random number that has been generated.

source: https://hackr.io/blog/java-projects
*/

import java.util.Scanner;

public class GuessingGame {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(scanner);
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        } while (playAgain);
    }

    public static void playGame(Scanner scanner) {
        int computerNumber = (int) (Math.random() * MAX_VALUE + MIN_VALUE);
        int userAnswer;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.println("Attempt " + attempt + ": Enter a guess between " + MIN_VALUE + " and " + MAX_VALUE + ": ");
            String response = scanner.nextLine();

            try {
                userAnswer = Integer.parseInt(response);
                System.out.println(determineGuess(userAnswer, computerNumber, count));
                count++;
                if (userAnswer == computerNumber) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                attempt--;
            }
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer < MIN_VALUE || userAnswer > MAX_VALUE) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.";
        } else {
            return "Your guess is too low, try again.";
        }
    }
}
