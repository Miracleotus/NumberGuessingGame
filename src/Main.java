import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            System.out.println("===== NUMBER GUESSING GAME =====");
            System.out.println("Choose a difficulty level:");
            System.out.println("1. Easy (1–50, 10 attempts)");
            System.out.println("2. Medium (1–100, 7 attempts)");
            System.out.println("3. Hard (1–200, 5 attempts)");
            System.out.print("Enter your choice (1–3): ");

            int maxNumber = 100;
            int attempts = 7;

            int choice = 0;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 3) break;
                }
                System.out.print("Invalid choice! Enter 1, 2, or 3: ");
                scanner.next();
            }


            switch (choice) {
                case 1:
                    maxNumber = 50;
                    attempts = 10;
                    break;
                case 2:
                    maxNumber = 100;
                    attempts = 7;
                    break;
                case 3:
                    maxNumber = 200;
                    attempts = 5;
                    break;
            }

            int target = rand.nextInt(maxNumber) + 1;
            int roundScore = 100;

            System.out.println("\nI'm thinking of a number between 1 and " + maxNumber);
            System.out.println("You have " + attempts + " attempts. Good luck!\n");

            boolean guessedCorrectly = false;

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": Enter your guess: ");


                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input! Enter a number: ");
                    scanner.next();
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > maxNumber) {
                    System.out.println("Please enter a number within 1–" + maxNumber);
                    i--;
                    continue;
                }

                if (guess == target) {
                    System.out.println("🎉 Correct! You guessed the number!");
                    guessedCorrectly = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                roundScore -= 10;
            }


            if (guessedCorrectly) {
                System.out.println("\n🎯 You earned " + roundScore + " points this round!");
                totalScore += roundScore;
            } else {
                System.out.println("\n❌ You're out of attempts!");
                System.out.println("The correct number was: " + target);
                System.out.println("You earned 0 points this round.");
            }

            System.out.println("🏆 Total Score: " + totalScore);

            // Replay
            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = scanner.next().toLowerCase().equals("y");
            System.out.println();
        }

        System.out.println("Thanks for playing! Final Score: " + totalScore);
        System.out.println("Goodbye!");
    }
}