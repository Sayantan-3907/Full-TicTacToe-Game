// author Sayantan
// version 1.0

import java.util.Scanner;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int slot = getUserInput();
        System.out.println("You selected slot: " + slot);
    }

    // Method to get user input
    public static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }
}