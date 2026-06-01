// This is the full version I made of the TicTacToe application feel free to use it or change anything for ur project 
// As this is my first project fully made 



import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // Creating the Tic-Tac-Toe board
    static char[][] board = new char[3][3];

    // Player symbols
    static char userSymbol;
    static char computerSymbol;
    static char currentPlayer;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("=== Welcome to Tic-Tac-Toe ===");

        createBoard();
        tossForFirstTurn();
        playGame();
    }

    // Fill the board with empty spaces
    public static void createBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Display the board
    public static void showBoard() {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    // Toss to decide who starts first
    public static void tossForFirstTurn() {

        int toss = random.nextInt(2);

        if (toss == 0) {

            userSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = userSymbol;

            System.out.println("You won the toss!");
        } else {

            userSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = computerSymbol;

            System.out.println("Computer won the toss!");
        }

        System.out.println("Your symbol: " + userSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
    }

    // Take input from user
    public static int getUserChoice() {

        int slot;

        while (true) {

            System.out.print("Choose a slot (1-9): ");

            if (scanner.hasNextInt()) {

                slot = scanner.nextInt();

                if (slot >= 1 && slot <= 9) {
                    return slot;
                } else {
                    System.out.println("Please enter a number from 1 to 9.");
                }

            } else {

                System.out.println("Invalid input. Enter numbers only.");
                scanner.next();
            }
        }
    }

    // Convert slot number to row
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // Convert slot number to column
    public static int getColumn(int slot) {
        return (slot - 1) % 3;
    }

    // Check whether move is valid
    public static boolean isValidMove(int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        return board[row][col] == '-';
    }

    // Put symbol on board
    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Computer makes random move
    public static void computerMove() {

        int slot;
        int row;
        int col;

        do {

            slot = random.nextInt(9) + 1;

            row = getRow(slot);
            col = getColumn(slot);

        } while (!isValidMove(row, col));

        placeMove(row, col, computerSymbol);

        System.out.println("Computer selected slot " + slot);
    }

    // Check winner
    public static boolean checkWinner(char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {

                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {

            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {

                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {

            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {

            return true;
        }

        return false;
    }

    // Check for draw
    public static boolean isDraw() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    // Main game loop
    public static void playGame() {

        boolean gameFinished = false;

        while (!gameFinished) {

            showBoard();

            if (currentPlayer == userSymbol) {

                System.out.println("Your turn");

                int slot = getUserChoice();

                int row = getRow(slot);
                int col = getColumn(slot);

                if (isValidMove(row, col)) {

                    placeMove(row, col, userSymbol);

                    if (checkWinner(userSymbol)) {

                        showBoard();
                        System.out.println("Congratulations! You won!");
                        gameFinished = true;

                    } else if (isDraw()) {

                        showBoard();
                        System.out.println("It's a draw!");
                        gameFinished = true;

                    } else {
                        currentPlayer = computerSymbol;
                    }

                } else {

                    System.out.println("That spot is already taken. Try another one.");
                }

            } else {

                System.out.println("Computer's turn");

                computerMove();

                if (checkWinner(computerSymbol)) {

                    showBoard();
                    System.out.println("Computer wins!");
                    gameFinished = true;

                } else if (isDraw()) {

                    showBoard();
                    System.out.println("It's a draw!");
                    gameFinished = true;

                } else {
                    currentPlayer = userSymbol;
                }
            }
        }

        System.out.println("Game Over");
    }
}