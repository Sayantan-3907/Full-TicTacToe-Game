// author Sayantan
// version 1.0


import java.util.Random;

public class TicTacToe {

    static char humanPlayer;
    static char computerPlayer;
    static char currentPlayer;

    public static void main(String[] args) {

        tossToDecidePlayer();

        System.out.println("Human is: " + humanPlayer);
        System.out.println("Computer is: " + computerPlayer);
        System.out.println("First turn: " + currentPlayer);
    }

    public static void tossToDecidePlayer() {
        Random random = new Random();

        // 0 = Human starts, 1 = Computer starts
        int toss = random.nextInt(2);

        if (toss == 0) {
            humanPlayer = 'X';
            computerPlayer = 'O';
            currentPlayer = humanPlayer;
            System.out.println("Human won the toss!");
        } else {
            humanPlayer = 'O';
            computerPlayer = 'X';
            currentPlayer = computerPlayer;
            System.out.println("Computer won the toss!");
        }
    }
}