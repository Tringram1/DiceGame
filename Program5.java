package mypack;

import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        displayWelcomeScreen();

        // Create two players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Create a six-sided die
        Die die = new Die(6);

        // Game loop
        while (true) {
            // Player 1's turn
            playTurn(player1, die);

            // Check if Player 1 wins
            if (player1.getPoints() == 1) {
                System.out.println(player1.getName() + " wins!");
                break;
            }

            // Player 2's turn
            playTurn(player2, die);

            // Check if Player 2 wins
            if (player2.getPoints() == 1) {
                System.out.println(player2.getName() + " wins!");
                break;
            }
        }
    }

    private static void displayWelcomeScreen() {
        System.out.println("Welcome to the Dice Game!");
        System.out.println("Each player starts with 50 points.");
        System.out.println("Roll the dice and subtract the value rolled from your points.");
        System.out.println("The first player to reach exactly 1 point wins.");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private static void playTurn(Player player, Die die) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the player to roll the dice
        System.out.println(player.getName() + "'s turn. Press enter to roll the dice.");
        scanner.nextLine();

        // Roll the dice
        die.roll();
        int rollValue = die.getValue();

        // Display the roll value
        System.out.println("You rolled a " + rollValue);

        // Update player's points
        int remainingPoints = player.getPoints() - rollValue;
        if (remainingPoints < 1) {
            player.addPoints(rollValue);
        } else {
            player.setPoints(remainingPoints);
        }

        // Display player's remaining points
        System.out.println("Your remaining points: " + player.getPoints());
        System.out.println();
    }
}

class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 50;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}

class Die {
    private int sides;
    private int value;

    public Die(int numSides) {
        sides = numSides;
    }

    public void roll() {
        // Generate a random value between 1 and the number of sides
        value = (int) (Math.random() * sides) + 1;
    }

    public int getValue() {
        return value;
    }
}

