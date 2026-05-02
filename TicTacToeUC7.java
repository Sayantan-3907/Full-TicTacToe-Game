// author Sayantan 
// version 1.0


import java.util.Random;

public class TicTacToe {

    static Random random = new Random();

    // Computer move method
    public static void computerMove(char[][] board, char computerSymbol) {

        int slot, row, col;

        do {
            // Generate random slot (1–9)
            slot = random.nextInt(9) + 1;

            // Convert to row & column (UC4)
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

        } while (!isValidMove(board, row, col)); // UC5 validation

        // Place move (UC6)
        placeMove(board, row, col, computerSymbol);

        System.out.println("Computer chose slot: " + slot);
    }

    // UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == '-');
    }

    // UC6
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Print board (UC1)
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        char computerSymbol = 'O';

        computerMove(board, computerSymbol);

        printBoard(board);
    }
}