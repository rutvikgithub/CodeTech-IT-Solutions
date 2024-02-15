package InternshipTasks;
import java.util.Scanner;

public class TextAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName;

        // Introduction
        System.out.println("Welcome to the Indian Traffic Police Adventure Game!");
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        System.out.println("\nHello, " + playerName + "! Let's begin.\n");

        // Game start
        System.out.println("You are driving in a busy city in India and suddenly you are stopped by a traffic police officer.");
        System.out.println("The officer approaches your vehicle.");

        // Main game loop
        boolean isAlive = true;
        boolean hasLicense = false;

        while (isAlive) {
            System.out.println("\nWhat do you do?");
            System.out.println("1. Show your driving license.");
            System.out.println("2. Try to bribe the officer.");
            System.out.println("3. Argue with the officer.");

            // Player's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("You show your driving license to the officer.");
                    if (!hasLicense) {
                        System.out.println("Officer: Your license seems to be expired. You will be fined.");
                        isAlive = false;
                    } else {
                        System.out.println("Officer: Okay, you can go.");
                    }
                    break;
                case 2:
                    System.out.println("You attempt to bribe the officer.");
                    System.out.println("Officer: Bribery is illegal! I'm reporting you to the authorities.");
                    isAlive = false;
                    break;
                case 3:
                    System.out.println("You start arguing with the officer.");
                    System.out.println("Officer: Stop arguing and cooperate!");
                    System.out.println("The situation escalates, and the officer takes you to the police station.");
                    isAlive = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        // Game over
        System.out.println("\nGame over! You have " + (isAlive ? "successfully navigated the situation." : "been caught by the police."));
    }
}
