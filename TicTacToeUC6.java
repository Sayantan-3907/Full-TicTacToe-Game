// author Sayantan
// version 1.0

public class TicTacToe {

    // Method to place move on board
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Utility to print board (from UC1)
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

        int row = 1;
        int col = 1;
        char currentPlayer = 'X';

        // Assume move already validated (UC5)
        placeMove(board, row, col, currentPlayer);

        System.out.println("Board after move:");
        printBoard(board);
    }
}