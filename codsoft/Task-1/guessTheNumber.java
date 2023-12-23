//TASK 1
//        1. Generate a random number within a specified range, such as 1 to 100.
//        2. Prompt the user to enter their guess for the generated number.
//        3. Compare the user's guess with the generated number and provide feedback on whether the guessis correct, too high, or too low.
//        4. Repeat steps 2 and 3 until the user guesses the correct number.
//        You can incorporate additional details as follows:
//        5. Limit the number of attempts the user has to guess the number.
//        6. Add the option for multiple rounds, allowing the user to play again.
//        7. Display the user's score, which can be based on the number of attempts taken or rounds won.

import java.util.Random;
import java.util.Scanner;
public class guessTheNumber {
    static final int HIGH_BOUND = 100;
    static final int LOW_BOUND = 1;
    static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);


        int score;
        do {
            boolean isGuessCorrect = false;
            int attempts = 0;
            int targetNumber = rand.nextInt(LOW_BOUND, HIGH_BOUND);
            System.out.println(targetNumber);
            score = 0;

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int userGuess = scanner.nextInt();
                scanner.nextLine();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    isGuessCorrect = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (!isGuessCorrect) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            } else {
                score += MAX_ATTEMPTS - attempts;
                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            }

            System.out.print("Do you want to play again? (yes/no): ");
        }
        while (scanner.nextLine().equalsIgnoreCase("yes"));
        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();
    }
    }
