// author Sayantan
// version 1.0

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char human = 'X';
    static char computer = 'O';
    static char currentPlayer = human;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        boolean gameOver = false;

        while (!gameOver) {

            printBoard();

            if (currentPlayer == human) {
                // Human turn
                int slot, row, col;

                do {
                    System.out.print("Enter slot (1-9): ");
                    slot = scanner.nextInt();

                    row = (slot - 1) / 3;
                    col = (slot - 1) % 3;

                } while (!isValidMove(row, col));

                placeMove(row, col, human);

            } else {
                // Computer turn
                computerMove();
            }

            // Check win or draw
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println(currentPlayer + " wins!");
                gameOver = true;

            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                gameOver = true;

            } else {
                // Switch turn
                currentPlayer = (currentPlayer == human) ? computer : human;
            }
        }
    }

    // UC1
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC5
    public static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == '-');
    }

    // UC6
    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7
    public static void computerMove() {
        int row, col, slot;

        do {
            slot = random.nextInt(9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (!isValidMove(row, col));

        placeMove(row, col, computer);
        System.out.println("Computer chose: " + slot);
    }

    // Win check (basic)
    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    // Draw check
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;

        return true;
    }
}